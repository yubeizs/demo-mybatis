package com.example.demo;

import java.util.List;

public class ParagraphVO extends BaseVO {

    private String name ;

    /**
     * 附件
     */
    @AttachAnnotion
    private List<AttachVO> attachVOS;

    /**
     * 附件关联Id
     */
    private String refId;

}
