package com.gzdmg.xmt.pyinterface.controller;

import com.gzdmg.xmt.pyinterface.model.Module;
import com.gzdmg.xmt.pyinterface.response.WebResponse;
import com.gzdmg.xmt.pyinterface.service.IModuleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weihongyan
 * @implNote <(▰˘◡˘▰)>
 * @since 14/08/2017 3:37 PM
 */

// 这里使用@RestController注解 作用:所有方法默认带@ResponseBody注解
@RestController
@RequestMapping("/module")
public class ModuleController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IModuleService iModuleService;

    @RequestMapping("/getAll.json")
    public WebResponse<?> getAll() {
        WebResponse response = new WebResponse<>();
        try {
            List<Module> moduleList = iModuleService.getAll();
            return response.success(moduleList);
        } catch (Exception e) {
            logger.error("getTextItem error:{}", e);
            return response.error(e.getMessage());
        }
    }
    
    @RequestMapping("/getById.json")
    public WebResponse<?> getAll(@RequestParam Long id) {
        WebResponse response = new WebResponse<>();
        try {
            Module module = iModuleService.getOne(id);
            return response.success(module);
        } catch (Exception e) {
            logger.error("getTextItem error:{}", e);
            return response.error(e.getMessage());
        }
    }
}
