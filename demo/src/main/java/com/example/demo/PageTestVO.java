package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class PageTestVO extends BaseVO {

    private String pageName;

    @AttachAnnotion
    private ParagraphVO paragraphVO;

    //单个文件
    private AttachInfoList attachInfo;

    //多个文件
    private List<AttachInfoList> attachInfos;

    private String imageRefId;

}
