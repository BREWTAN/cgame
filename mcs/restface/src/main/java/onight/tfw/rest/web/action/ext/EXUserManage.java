package onight.tfw.rest.web.action.ext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.rest.db.ext.UserManageMapper;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.bean.ReturnInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/usermanage")
public class EXUserManage {

	private static UserManageMapper userManageMapper = (UserManageMapper) BeanFactory
			.getBean("userManageMapper");

	@RequestMapping(value = "/resetPassWord", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo resetPassWord(HttpServletRequest req) {
		try {
			Map<String,String> info = new HashMap<String,String>();
			info.put("userId",req.getParameter("userId"));
			info.put("password",req.getParameter("password"));
			int count = userManageMapper.updateByPrimaryKey(info);
			log.debug("update count is " + count);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("SysUserInfo update by key error..",e);
		}
		return ReturnInfo.Faild;
	}
	
	@RequestMapping(value = "/editPassword", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo editPassWord(HttpServletRequest req) {
		try {
			Map<String,String> info = new HashMap<String,String>();
			info.put("userId",req.getParameter("userId"));
			info.put("oldPassword",req.getParameter("oldPassword"));
			info.put("newPassword",req.getParameter("newPassword"));
			int count = userManageMapper.updatePwdByPrimaryKey(info);
			log.debug("update count is " + count);
			return count==1?ReturnInfo.Success:ReturnInfo.Faild;
		} catch (Exception e) {
			log.warn("SysUserInfo update by key error..",e);
		}
		return ReturnInfo.Faild;
	}
}
