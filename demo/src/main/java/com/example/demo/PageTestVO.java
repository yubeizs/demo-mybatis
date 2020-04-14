package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class PageTestVO extends BaseVO {

    private String pageName;

    private ParagraphVO paragraphVO;

    @AttachAnnotion
    private List<AttachVO> imageVO;

    private String imageRefId;

}
