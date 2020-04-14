package com.example.demo;

import lombok.Data;

import java.util.Date;

/**
 * 基础类
 */
@Data
public class BaseVO {

    private String id;

    private String createdBy;

    private String updatedBy;

    private Date createDate;

    private Data updateDate;


}
