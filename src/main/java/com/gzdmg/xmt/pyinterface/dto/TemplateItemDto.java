/**
 * Copyright © 2017 公司名. All rights reserved.
 *
 * @Title: TemplateItemVO.java
 * @Prject: pydao
 * @Package: com.gzdmg.xmt.pydao.model
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年8月15日 下午3:45:00
 * @version: V1.0
 */

package com.gzdmg.xmt.pyinterface.dto;

import java.util.Date;

/**
 * @ClassName: TemplateItemVO
 * @Description: TODO
 * @author: siyuan
 * @date: 2017年8月15日 下午3:45:00
 */
public class TemplateItemDto {

    private Long id;
    // 图片链接
    private String imageLink;

    /**
     * 类型（图文、视频或合集） 1：图文 2：视频 3：合集
     */
    private int type = 0;

    private Date createdDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
