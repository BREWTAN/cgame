package onight.tfw.rest.web.action.ext;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysRoleAction;
import onight.tfg.ordbgens.sys.entity.TSysRoleActionExample;
import onight.tfg.ordbgens.sys.mapper.TSysActionMapper;
import onight.tfg.ordbgens.sys.mapper.TSysRoleActionMapper;
import onight.tfw.rest.db.service.DataService;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.action.BasicCtrl;
import onight.tfw.rest.web.bean.ReturnInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/exroleaction")
public class EXRoleActionCtrl extends BasicCtrl {

	private static TSysRoleActionMapper sysRoleActionMapper = (TSysRoleActionMapper) BeanFactory.getBean("tSysRoleActionMapper");

	private static TSysActionMapper sysActionMapper = (TSysActionMapper) BeanFactory.getBean("tSysActionMapper");

	private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	@RequestMapping(value = "/batch", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insertBatch(@RequestBody List<LinkedHashMap<String, String>> lists, HttpServletRequest req) {
		try {
			for (LinkedHashMap<String, String> entry : lists) {
				TSysRoleActionExample action = new TSysRoleActionExample();
				action.createCriteria().andRoleIdEqualTo((entry.get("roleId")));
				sysRoleActionMapper.deleteByExample(action);
			}

			for (LinkedHashMap<String, String> entry : lists) {
				if("-1".equals(entry.get("actionId"))){
					return ReturnInfo.Success;
				}
				TSysRoleAction menu = new TSysRoleAction();
				menu.setId(entry.get("id"));
				menu.setActionId(Long.parseLong(entry.get("actionId")));
				menu.setRoleId(entry.get("roleId"));
				menu.setStatus(Long.parseLong(entry.get("status")));
				sysRoleActionMapper.insert(menu);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("SysRoleMenuCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	/*public MenuInfo infoMenu(SysMenu menu, List<MenuInfo> children) {
		MenuInfo info = new MenuInfo();
		info.setIcon(menu.getIcon());
		info.setName(menu.getMenuName());
		info.setUrl(menu.getMenuUrl());
		info.setChildren(children);
		return info;
	}

	@RequestMapping(value = "/{roles}", method = RequestMethod.GET)
	@ResponseBody
	public Object menuByRole(@PathVariable String roles, HttpServletRequest req) {
		try {
			List<String> iroles = new ArrayList<String>();
			for (String r : roles.split(",")) {
				iroles.add(r);
			}
			SysRoleMenuExample example = new SysRoleMenuExample();
			example.createCriteria().andRoleIdIn(iroles);
			List<SysRoleMenu> rolemenus = sysRoleMenuMapper.selectByExample(example);

			HashMap<Integer, SysMenu> menubyId = new HashMap<>();
			for (SysRoleMenu rm : rolemenus) {
				SysMenuKey menukey = new SysMenuKey();
				menukey.setMenuId(rm.getMenuId());
				SysMenu menu = sysMenuMapper.selectByPrimaryKey(menukey);
				if (menu != null) {
					menubyId.put(menu.getMenuId(), menu);
				}
			}

			HashMap<Integer, MenuInfo> treemenu = new HashMap<>();
			for (Map.Entry<Integer, SysMenu> entry : menubyId.entrySet()) {
				Integer id = entry.getKey();
				SysMenu menu = entry.getValue();
				if (menu.getParentId() != null && menubyId.containsKey(menu.getParentId())) {
					SysMenu parent = menubyId.get(menu.getParentId());
					MenuInfo info = treemenu.get(parent.getMenuId());
					if (info == null || info.getChildren() == null) {
						info = infoMenu(parent, new ArrayList<MenuInfo>());
						treemenu.put(parent.getMenuId(), info);
					}

					info.getChildren().add(infoMenu(menu, null));
				} else if (!treemenu.containsKey(menu.getMenuId())) {
					treemenu.put(menu.getMenuId(), infoMenu(menu, null));
				}
			}

			return treemenu.values();
		} catch (Exception e) {
			log.warn("SysRoleMenuCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}*/
}
