package com.pojo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


@Data
public class Blog {
    private String id;
    private String title;
    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    int views;


//    String pattern = "yyyy-MM-dd HH:mm:ss";
//    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


}
