package com.example.vo;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class RequestVo {

    private  String uuid ;

    private Integer minAge;

    private String maxAge;

    // 学校id必须不为空

    @NotNull(message = "学校id不能为空")
    private String schoolId;

}
