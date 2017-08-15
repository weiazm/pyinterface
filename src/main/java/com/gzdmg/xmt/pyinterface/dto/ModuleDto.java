/**
 * Copyright © 2017 公司名. All rights reserved.
 *
 * @Title: ModuleVO.java
 * @Prject: pydao
 * @Package: com.gzdmg.xmt.pydao.model
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年8月15日 下午3:39:43
 * @version: V1.0
 */
package com.gzdmg.xmt.pyinterface.dto;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: ModuleVO
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年8月15日 下午3:39:43
 */
public class ModuleDto {

    private Long id;
    // 模块名称
    private String name;
    // 模块排序序号
    private int mOrder;
    // 模块上线状态
    private int mStatus;

    private Date createdDate = new Date();

    private Date updatedDate;

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

    public int getmOrder() {
        return mOrder;
    }

    public void setmOrder(int mOrder) {
        this.mOrder = mOrder;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
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

    public TemplateDto getTemplateDto() {
        return templateDto;
    }

    public void setTemplateDto(TemplateDto templateDto) {
        this.templateDto = templateDto;
    }

    private TemplateDto templateDto;

    

}
