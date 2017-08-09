package com.gzdmg.xmt.pyinterface.controller;

import javax.annotation.Resource;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ctc.wstx.util.StringUtil;
import com.gzdmg.xmt.pyinterface.service.IUserService;

@Controller
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Resource(name = "userService")
	private IUserService userService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginIndex")
	public String login(HttpSession session, String username, String password) {
		try {
			if (userService.login(username, password)) {
				// 登陆成功
				session.setAttribute("username", username);
				return "index";
			} else {
				// 登陆失败
				return "login";
			}
		} catch (Exception e) {
			return "error";
		}

	}

	@RequestMapping("/logout")
	public String clientLoginOut(HttpSession httpSession) {
		httpSession.invalidate();
		return "login";
	}

	@RequestMapping("/changePasswd")
	public String changePasswd() {
		return "change_passwd";
	}

	@RequestMapping("/submitChangePasswd")
	public String submitChangePasswd(String old_passwd, String new_passwd) {

		try {
			if (StringUtils.isEmpty(old_passwd) || StringUtils.isEmpty(new_passwd))
				throw new Exception("password null!");
			int reuslt = userService.changePasswd(old_passwd, new_passwd);
			if (reuslt != 1)
				throw new Exception("Change password fail! result:" + reuslt);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return "error";
		}
		return "success";
	}

}
