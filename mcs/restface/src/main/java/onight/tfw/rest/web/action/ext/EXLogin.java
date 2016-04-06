package onight.tfw.rest.web.action.ext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysUser;
import onight.tfg.ordbgens.sys.entity.TSysUserExample;
import onight.tfg.ordbgens.sys.entity.TSysUserRole;
import onight.tfg.ordbgens.sys.entity.TSysUserRoleExample;
import onight.tfg.ordbgens.sys.mapper.TSysUserMapper;
import onight.tfg.ordbgens.sys.mapper.TSysUserRoleMapper;
import onight.tfw.rest.db.service.DataService;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.action.BasicCtrl;
import onight.tfw.rest.web.bean.ReturnInfo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/user")
@Scope("session")
public class EXLogin extends BasicCtrl implements Serializable{

	private static TSysUserMapper sysUserMapper = (TSysUserMapper) BeanFactory
			.getBean("tSysUserMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory
			.getBean("mysqlDataService");

	private static TSysUserRoleMapper sysUserRoleMapper = (TSysUserRoleMapper) BeanFactory
			.getBean("tSysUserRoleMapper");

	@Data
	class LoginReturn {
		List<String> roles;
		String username;
		String loginname;
		String userid;
		String branchid;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo login(HttpServletRequest req) {
		try {
			String loginName = req.getParameter("loginname");
			String password = req.getParameter("password");
			TSysUserExample example = new TSysUserExample();
			example.createCriteria().andLoginNameEqualTo(loginName)
					.andPasswordEqualTo(password);
			List<TSysUser> users = sysUserMapper.selectByExample(example);

			if (users == null || users.size() != 1) {
				return ReturnInfo.Faild;
			}

			HttpSession session = req.getSession(true);
			TSysUser user = users.get(0);
			session.setAttribute("user", user);
			// get user menus
			TSysUserRoleExample roleEx = new TSysUserRoleExample();
			roleEx.createCriteria().andUserIdEqualTo(user.getUserId());
			List<TSysUserRole> roles = sysUserRoleMapper.selectByExample(roleEx);

			List<String> iroles = new ArrayList<String>();
			for (TSysUserRole urole : roles) {
				iroles.add(urole.getRoleId());
			}
			session.setAttribute("roles", iroles);

			LoginReturn lr=new LoginReturn();
			lr.setRoles(iroles);
			lr.setLoginname(user.getLoginName());
			lr.setUserid(""+user.getUserId());
			lr.setUsername(user.getUserName());
			// sysUserMapper.insert(info);

			return new ReturnInfo("success", 0, lr, true);

		} catch (Exception e) {
			log.warn("TSysUserCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ReturnInfo logout(HttpServletRequest req,HttpServletResponse res) {
		try {
			HttpSession session = req.getSession(true);
			//TSysUser user = (TSysUser)session.getAttribute("user");
			session.removeAttribute("user");
			//req.getRequestDispatcher("/login.html").forward(req, res);
			//res.sendRedirect("http://localhost/msbao/login.html");
			//TSystem.out.println(session.getAttribute("user")==null);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TSysUserCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}
}
