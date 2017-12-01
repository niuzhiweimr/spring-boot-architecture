package com.syhd.portal.action;


import java.util.HashMap;
import java.util.Map;

import com.syhd.portal.exception.DataException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.syhd.portal.service.IUserService;

@RequestMapping("/uportal")
@RestController
public class UserAction {

	@Autowired
	private IUserService userService;

    private Logger logger = Logger.getLogger(UserAction.class);
	// 通过用户id获取userEbo对象
	@GetMapping("/getuser/{id}")
	public @ResponseBody
	Map<String, Object> getUserById(@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		try {
			/* Integer uid = Util.parseNumVl(request.getParameter("uid"), 0); */

			map.put("data", userService.getUserById(id));
			map.put("message", "获取用户成功<syhd-user>");
			map.put("status", 100);
			return map;
		} catch (DataException e) {
			logger.error(e.getMessage());
			map.put("status", 500);
			map.put("message", e.getMessage());
		}
		return map;
	}
}
