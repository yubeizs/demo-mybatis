package com.example.demo;

import lombok.Data;

import java.util.List;

@Data
public class AttachInfoList extends BaseVO{

    private String refId ;

    private List<AttachVO> attachVOList;
}
