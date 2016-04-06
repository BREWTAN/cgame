package onight.tfw.rest.web.action.ext;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.rest.db.ext.UserRoleMapper;
import onight.tfw.rest.utils.BeanFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/userrole")
public class EXUserRole {

	private static UserRoleMapper userRoleMapper = (UserRoleMapper) BeanFactory
			.getBean("userRoleMapper");

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object getrole(HttpServletRequest req) {
		Object ret = userRoleMapper.selectUserRoles();
		log.debug("ret.getrole==" + ret);
		return ret;
	}
}
