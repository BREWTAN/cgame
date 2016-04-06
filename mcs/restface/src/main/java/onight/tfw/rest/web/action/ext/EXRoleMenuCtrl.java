package onight.tfw.rest.web.action.ext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import onight.tfg.ordbgens.sys.entity.TSysMenu;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenu;
import onight.tfg.ordbgens.sys.entity.TSysRoleMenuExample;
import onight.tfg.ordbgens.sys.mapper.TSysRoleMenuMapper;
import onight.tfw.rest.db.ext.EXSysRoleMenuMapper;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.action.BasicCtrl;
import onight.tfw.rest.web.bean.MenuInfo;
import onight.tfw.rest.web.bean.ReturnInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/exrolemenu")
public class EXRoleMenuCtrl extends BasicCtrl {

	private static TSysRoleMenuMapper sysRoleMenuMapper = (TSysRoleMenuMapper) BeanFactory.getBean("tSysRoleMenuMapper");
	private static EXSysRoleMenuMapper exTSysRoleMenuMapper = (EXSysRoleMenuMapper) BeanFactory.getBean("exSysRoleMenuMapper");
	//private static TSysMenuMapper sysMenuMapper = (TSysMenuMapper) BeanFactory.getBean("sysMenuMapper");

	//private static DataService mysqlDataService = (DataService) BeanFactory.getBean("mysqlDataService");

	@RequestMapping(value = "/batch", method = RequestMethod.POST)
	@ResponseBody
	public ReturnInfo insertBatch(@RequestBody List<LinkedHashMap<String, String>> lists, HttpServletRequest req) {
		try {
			for (LinkedHashMap<String, String> entry : lists) {
				TSysRoleMenuExample menu = new TSysRoleMenuExample();
				menu.createCriteria().andRoleIdEqualTo((entry.get("roleId")));
				sysRoleMenuMapper.deleteByExample(menu);
			}

			for (LinkedHashMap<String, String> entry : lists) {
				TSysRoleMenu menu = new TSysRoleMenu();
				menu.setId(entry.get("id"));
				menu.setMenuId(Integer.parseInt(entry.get("menuId")));
				menu.setRoleId(entry.get("roleId"));
				menu.setStatus(Integer.parseInt(entry.get("status")));
				sysRoleMenuMapper.insert(menu);
			}
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("TSysRoleMenuCtrl insert error..", e);
			// e.printStackTrace();
		}
		return ReturnInfo.Faild;
	}

	public MenuInfo infoMenu(TSysMenu menu, List<MenuInfo> children) {
		MenuInfo info = new MenuInfo();
		info.setIcon(menu.getIcon());
		info.setName(menu.getMenuName());
		info.setUrl(menu.getMenuUrl());
		info.setChildren(children);
		return info;
	}

	@RequestMapping(value = "/{roles}", method = RequestMethod.GET)
	@ResponseBody
	public Object menuByRole(@PathVariable String roles, HttpServletRequest req,HttpServletResponse res) {
		try {
			StringBuffer sb = new StringBuffer("SELECT m.* FROM T_SYS_ROLE r,T_SYS_ROLE_MENU rm,T_SYS_MENU m WHERE r.ROLE_ID = rm.ROLE_ID AND m.MENU_ID = rm.MENU_ID AND m.LEVEL=0 AND rm.ROLE_ID IN ( ");
			StringBuffer sb1 = new StringBuffer("SELECT m.* FROM T_SYS_ROLE r,T_SYS_ROLE_MENU rm,T_SYS_MENU m WHERE r.ROLE_ID = rm.ROLE_ID AND m.MENU_ID = rm.MENU_ID AND m.LEVEL=1 AND rm.ROLE_ID IN ( ");
			List<MenuInfo> menuInfoList = new ArrayList<MenuInfo>();
			for (String r : roles.split(",")) {
				sb.append(Integer.parseInt(r)+",");
				sb1.append(Integer.parseInt(r)+",");
			}
			sb = new StringBuffer(sb.substring(0,sb.length()-1));
			sb1 = new StringBuffer(sb1.substring(0,sb1.length()-1));
			sb.append(" )  GROUP BY MENU_ID");
			List<TSysMenu> menuParents = exTSysRoleMenuMapper.selectAllParent(sb.toString());
			for(TSysMenu menuParent:menuParents){
				MenuInfo menuInfo = new MenuInfo();
				menuInfo.setName(menuParent.getMenuName());
				menuInfo.setIcon(menuParent.getIcon());
				menuInfo.setUrl(menuParent.getMenuUrl());
				StringBuffer sb2 = new StringBuffer(sb1.toString());
				sb2.append(")  AND m.PARENT_ID = " + menuParent.getMenuId()).append("  GROUP BY MENU_ID");
				List<TSysMenu> childrens = exTSysRoleMenuMapper.selectChildrenByParent(sb2.toString());
				if(childrens!=null&&childrens.size()>0){
					List<MenuInfo> menuInfoChildrenList = new ArrayList<MenuInfo>();
					for(TSysMenu children:childrens){
						MenuInfo childrenMenuInfo = new MenuInfo();
						childrenMenuInfo.setName(children.getMenuName());
						childrenMenuInfo.setIcon(children.getIcon());
						childrenMenuInfo.setUrl(children.getMenuUrl());
						childrenMenuInfo.setChildren(null);
						menuInfoChildrenList.add(childrenMenuInfo);
					}
					menuInfo.setChildren(menuInfoChildrenList);
				}
				menuInfoList.add(menuInfo);
			}
			return menuInfoList;
			/*TSysRoleMenuExample example = new TSysRoleMenuExample();
			example.createCriteria().andRoleIdIn(iroles);
			List<TSysRoleMenu> rolemenus = sysRoleMenuMapper.selectByExample(example);

			HashMap<Integer, TSysMenu> menubyId = new HashMap<>();
			for (TSysRoleMenu rm : rolemenus) {
				TSysMenuKey menukey = new TSysMenuKey();
				menukey.setMenuId(rm.getMenuId());
				TSysMenu menu = sysMenuMapper.selectByPrimaryKey(menukey);
				if (menu != null) {
					menubyId.put(menu.getMenuId(), menu);
				}
			}

			HashMap<Integer, MenuInfo> treemenu = new HashMap<>();
			for (Map.Entry<Integer, TSysMenu> entry : menubyId.entrySet()) {
				Integer id = entry.getKey();
				TSysMenu menu = entry.getValue();
				if (menu.getParentId() != null && menubyId.containsKey(menu.getParentId())) {
					TSysMenu parent = menubyId.get(menu.getParentId());
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
			return treemenu.values();*/
		} catch (Exception e) {
			log.warn("TSysRoleMenuCtrl insert error..", e);
			// e.printStackTrace();
			String url = ("loginRedirectUrl");
			try {
				res.sendRedirect(url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return ReturnInfo.Faild;
	}
}
