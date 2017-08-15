
/**
 * Copyright © 2017 公司名. All rights reserved.
 *
 * @Title: TemplateVO.java
 * @Prject: pydao
 * @Package: com.gzdmg.xmt.pydao.model
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年8月15日 下午3:43:37
 * @version: V1.0
 */
package com.gzdmg.xmt.pyinterface.dto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: TemplateVO
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年8月15日 下午3:43:37
 */
public class TemplateDto {

    private Long id;

    private String name;

    private Date createdDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<TemplateItemDto> getTemplateItemDtos() {
        return templateItemDtos;
    }

    public void setTemplateItemDtos(List<TemplateItemDto> templateItemDtos) {
        this.templateItemDtos = templateItemDtos;
    }

    private Date updatedDate;

    private List<TemplateItemDto> templateItemDtos;

    

}
