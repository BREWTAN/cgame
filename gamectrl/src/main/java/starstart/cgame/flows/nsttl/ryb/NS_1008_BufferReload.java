package starstart.cgame.flows.nsttl.ryb;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.ipojo.annotations.Provides;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.msg.entity.BufferCtrlBean;
import starstart.cgame.flows.msg.entity.RP101;
import starstart.cgame.flows.msg.entity.RP103;
import starstart.cgame.flows.msg.entity.TransBufferMsg;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import cn.msec.bao.outils.serialize.SerializerFactory;
import cn.msec.bao.outils.serialize.SerializerUtil;
import cn.msec.ojpa.api.IJPAClient;
import cn.msec.ojpa.api.OJpaDAO;
import cn.msec.ojpa.api.annotations.StoreDAO;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
import cn.msec.osgi.ofw.IActor;

/**
 * 
 *缓存中取申购、赎回信息重新放回队列中
 *
 */
@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class, IActor.class })
@Slf4j
@Data
public class NS_1008_BufferReload extends NSettle_BaseActor<CalcMutex> {

	@StoreDAO(domain = BufferCtrlBean.class, key = "id", target = "redis")
	protected OJpaDAO<BufferCtrlBean> buffCtrlDao;

	@StoreDAO(domain = TransBufferMsg.class, target = "cass")
	protected OJpaDAO<TransBufferMsg> bufferMsgDao;

	public static final int SQL_LIMIT = 1000;

	@Override
	public void processMessage(CalcMutex pack) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Object ret = null;
			do {
				//查询缓存中有无交易日期小于当日的数据
				ret = bufferMsgDao.doBySQL("SELECT * FROM transbuffermsg where status='0' and postdate <= '" + sdf.format(new Date()) + "' LIMIT " + SQL_LIMIT
						+ " ALLOW FILTERING;");
				if (ret != null && ret instanceof List) {
					List<TransBufferMsg> msgs = SerializerUtil.deserializeArray(ret, TransBufferMsg.class);
					log.debug("找到列表msgs.size()==" + msgs.size());
					if (msgs.size() == 0){
						break;
					}
					//找到数据逐条推送队列
					for (TransBufferMsg msg : msgs) {
						// 发送到ctrl队列
						log.info("msg:"+msg.toString());
						String json = msg.getBodystr();
						log.info("json"+json);
						if (!StringUtils.isBlank(json)) {
							Serializable decobj = null;
							if ("MSCS.101".equals(msg.getTranstype())) {
								RP101 rp101 = SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON).deserialize(json.getBytes("UTF-8"), RP101.class);
								decobj = (Serializable) SerializerUtil.serialize(rp101);
								log.info("从缓冲重新放回到队列:" + rp101.getMsgsentid());
							} else if ("MSCS.103".equals(msg.getTranstype())) {
								RP103 rp103 = SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON).deserialize(json.getBytes("UTF-8"), RP103.class);
								decobj = (Serializable) SerializerUtil.serialize(rp103);
								log.info("从缓冲重新放回到队列:" + rp103.getMsgsentid());
							}else{
								log.warn("数据错误："+json);
								break;
							}
							if (decobj != null) {
								sendMessage("FPXY_" + msg.getTranstype(), decobj);
							}
						}
						bufferMsgDao.deleteByPrimaryKey(msg);

					}
				} else {
					break;
				}
			} while (ret != null && ret instanceof List && ((List) ret).size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException();
		}

	}

	@Override
	public SettleSteps getSettleStep() {
		return SettleSteps.BufferMsg_Proc;
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String method = req.getParameter("method");
		if ("delbyid".equals(method)) {
			if (!StringUtils.isBlank(id)) {
				TransBufferMsg msg = new TransBufferMsg();
				msg.setId(id);
				int ret = bufferMsgDao.deleteByPrimaryKey(msg);
				resp.getWriter().write("{\"code\":1,\"method\":\""+method+"\",\"delcount\":" + ret + "}");
			} else {
				resp.getWriter().write("{\"code\":-1,\"method\":\""+method+"\"}");
			}
		}else
		if("redis.get".equals(method))
		{
			//获取redis的代码
			BufferCtrlBean ctrl=new BufferCtrlBean();
			ctrl.setId(id);
			BufferCtrlBean bufctrl = buffCtrlDao.selectByPrimaryKey(ctrl);
			resp.getWriter().write(SerializerFactory.getSerializer(SerializerFactory.SERIALIZER_JSON).serialize(bufctrl).toString());
		}
		else if("redis.remove".equals(method))
		{
			//获取redis的代码
			BufferCtrlBean ctrl=new BufferCtrlBean();
			ctrl.setId(id);
			buffCtrlDao.deleteByPrimaryKey(ctrl);
			int ret = buffCtrlDao.deleteByPrimaryKey(ctrl);
			resp.getWriter().write("{\"code\":1,\"method\":\""+method+"\",\"delcount\":" + ret + "}");
		}
		
		else{
			resp.getWriter().write("{\"code\":-2,\"method\":\""+method+"\"}");
		}
		
	}

	@Override
	public String getWebPath() {
		return "/nsttl/buffctrl";
	}

}
