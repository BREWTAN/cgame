package onight.tfw.rest.web.action.ext;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysUserRole;
import onight.tfg.ordbgens.sys.entity.TSysUserRoleExample;
import onight.tfg.ordbgens.sys.mapper.TSysUserRoleMapper;
import onight.tfw.rest.db.ext.EXSysUserRoleMapper;
import onight.tfw.rest.db.ext.EXSysUserRoleMapper.Cou;
import onight.tfw.rest.utils.BeanFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
@RequestMapping("/exsysuserrole")
public class EXSysUserRoleCtrl {

	private static TSysUserRoleMapper sysUserRoleMapper = 
			(TSysUserRoleMapper)BeanFactory.getBean("tSysUserRoleMapper");
    private static EXSysUserRoleMapper eXSysUserRoleMapper = 
    		(EXSysUserRoleMapper)BeanFactory.getBean("eXSysUserRoleMapper");
	@RequestMapping(value="getUserRole/{userId},{roleId}",method=RequestMethod.GET)
	@ResponseBody
	public int get(@PathVariable String userId,@PathVariable String roleId,HttpServletRequest req) {
		List<TSysUserRole> list = null;
		TSysUserRoleExample example = new TSysUserRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId).andUserIdEqualTo(userId);
		list = sysUserRoleMapper.selectByExample(example);
		return list.size();
	}
	
	@RequestMapping(value="getExtis/{roles},{url}",method=RequestMethod.GET)
	@ResponseBody
	public int getExtis(@PathVariable String roles,@PathVariable String url,HttpServletRequest req) {
		List<Cou> list = null;
		/*Map<String,String> map = new HashMap<String,String>();
		map.put("roles",roles);
		map.put("url",url);*/
		String role = "";
		for (String r : roles.split(",")) {
			role = role + r + ",";
		}
		role = role.substring(0,role.length()-1);
		String sql = "SELECT COUNT(RM.ID) cou FROM T_SYS_ROLE R,T_SYS_MENU M,T_SYS_ROLE_MENU RM WHERE R.ROLE_ID=RM.ROLE_ID AND M.MENU_ID=RM.MENU_ID AND M.MENU_URL LIKE '%"+url+"%' AND R.ROLE_ID in ("+role+")";
		/*SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId).andUserIdEqualTo(userId);
		list = sysUserRoleMapper.selectByExample(example);*/
		list = eXSysUserRoleMapper.selectCount(sql);
		String cou = list.get(0).getCou();
		return Integer.parseInt(cou);
	}
	@RequestMapping(value="/saveUserRole/{userId},{roleIds}",method=RequestMethod.GET)
	@ResponseBody
	public String saveUserRole(@PathVariable String userId,@PathVariable String roleIds,HttpServletRequest req) {
		try {
			TSysUserRoleExample example=new TSysUserRoleExample();
			example.createCriteria().andUserIdEqualTo(userId);
			sysUserRoleMapper.deleteByExample(example);
			if(roleIds!=null&&!org.apache.commons.lang3.StringUtils.isEmpty(roleIds)){
				String roleId[] = roleIds.split("-");
				for(String rId:roleId){
					TSysUserRole sur = new TSysUserRole();
					sur.setRoleId(rId);
					sur.setUserId(userId);
					sur.setStatus(1);
					sur.setUserRoleId(UUID.randomUUID().toString());
					sysUserRoleMapper.insert(sur);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
}
