package com.gzdmg.xmt.pyinterface.controller;

import com.google.common.collect.Maps;
import com.gzdmg.xmt.pyinterface.model.TextItem;
import com.gzdmg.xmt.pyinterface.response.WebResponse;
import com.gzdmg.xmt.pyinterface.service.ITextItemService;
import com.gzdmg.xmt.pyinterface.service.IUserService;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/test.json")
	@ResponseBody
	public Map<String, Object> test(){
		Map<String, Object> result = Maps.newHashMap();
		result.put("ssy", "dsb");
		return result;
	}
	
    @Autowired
    private ITextItemService iTextItemService;

    @RequestMapping("/getTextItem.json")
    @ResponseBody
    public WebResponse<?> getTextItem(@RequestParam(required = false) Long textItemId) {
        WebResponse response = new WebResponse<>();
        if (null == textItemId) {
            return response.error("textItemId is null!");
        }
        try {
            TextItem textItem = iTextItemService.getOne(textItemId);
            if (null == textItem) {
                return response.error(String.format("can not find textItem by id:%s", textItemId));
            }
            return response.success(textItem);
        } catch (Exception e) {
            logger.error("getTextItem error:{}", e);
            return response.error(e.getMessage());
        }
    }
	
}
