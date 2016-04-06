package onight.tfw.rest.web.action.ext;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysRole;
import onight.tfg.ordbgens.sys.entity.TSysRoleExample;
import onight.tfg.ordbgens.sys.mapper.TSysRoleMapper;
import onight.tfw.rest.utils.BeanFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/exsysrole")
public class EXSysRoleCtrl {

	private static TSysRoleMapper sysRoleMapper = 
			(TSysRoleMapper)BeanFactory.getBean("tSysRoleMapper");

	@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
	@ResponseBody
	public List<TSysRole> getLandcount(HttpServletRequest req) {
		List<TSysRole> list = null;
		TSysRoleExample example = new TSysRoleExample();
		example.createCriteria().andRoleIdIsNotNull().andStatusEqualTo(new Integer(1));
		list = sysRoleMapper.selectByExample(example);
		return list;
	}
	
}
