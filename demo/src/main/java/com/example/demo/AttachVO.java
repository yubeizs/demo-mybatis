package com.example.demo;


import lombok.Data;

/**
 * 附件VO，图片文件之类
 */
@Data
public class AttachVO extends  BaseVO{

    //附件id
    private String attachId ;
    //附件名称
    private String name;
    // 附件url
    private String url;

    public AttachVO(String attachId, String name) {
        this.attachId = attachId;
        this.name = name;
    }
}
