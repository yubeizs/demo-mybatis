package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class ParagraphVO extends BaseVO {

    private String name ;

    /**
     * 附件
     */
    @AttachAnnotion
    private AttachInfoList attachInfoLists;

    /**
     * 附件关联Id
     */
    private String refId;

}
