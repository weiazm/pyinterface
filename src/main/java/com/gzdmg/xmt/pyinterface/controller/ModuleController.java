package com.gzdmg.xmt.pyinterface.controller;

import com.google.common.collect.Lists;
import com.gzdmg.xmt.pyinterface.dto.ModuleDto;
import com.gzdmg.xmt.pyinterface.dto.TemplateDto;
import com.gzdmg.xmt.pyinterface.dto.TemplateItemDto;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.Module;
import com.gzdmg.xmt.pyinterface.model.TemplateItem;
import com.gzdmg.xmt.pyinterface.response.WebResponse;
import com.gzdmg.xmt.pyinterface.service.IModuleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping("/getAllDtos.json")
    public WebResponse<List<ModuleDto>> getAllDtos() {
        WebResponse<List<ModuleDto>> response = new WebResponse<>();
        try {
            List<ModuleDto> moduleList = getAllModuleDtos();
            return response.success(moduleList);
        } catch (Exception e) {
            logger.error("getTextItem error:{}", e);
            return response.error(e.getMessage());
        }
    }
    
    private List<ModuleDto> getAllModuleDtos() throws DAOException {
        List<Module> moduleList = iModuleService.getAll();
        List<ModuleDto> result = new ArrayList<>();
        for(Module module : moduleList){
            ModuleDto moduleDto = new ModuleDto();
            moduleDto.setId(module.getId());
            moduleDto.setmOrder(module.getmOrder());
            moduleDto.setmStatus(module.getmStatus());
            moduleDto.setName(module.getName());
            moduleDto.setCreatedDate(module.getCreatedDate());
            moduleDto.setUpdatedDate(module.getUpdatedDate());

            TemplateDto templateDto = new TemplateDto();
            templateDto.setId(module.getTemplate().getId());
            templateDto.setName(module.getTemplate().getName());
            templateDto.setCreatedDate(module.getTemplate().getCreatedDate());
            templateDto.setUpdatedDate(module.getTemplate().getUpdatedDate());
            
            List<TemplateItemDto> itemDtos = new ArrayList<>();
            for(TemplateItem templateItem : module.getTemplate().getTemplateItems()){
                TemplateItemDto templateItemDto = new TemplateItemDto();
                templateItemDto.setId(templateItem.getId());
                templateItemDto.setImageLink(templateItem.getImageLink());
                templateItemDto.setType(templateItem.getType());
                templateItemDto.setCreatedDate(templateItem.getCreatedDate());
                itemDtos.add(templateItemDto);
            }
            templateDto.setTemplateItemDtos(itemDtos);
            
            moduleDto.setTemplateDto(templateDto);
            result.add(moduleDto);
        }
        return result;
    }
}
