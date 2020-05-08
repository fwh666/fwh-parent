package com.fuwenhao.bean;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/5/7 5:05 下午
 */
@Data
@Document(collation = "fwh")
public class User {
    @Id
    private long id;
    private String name;
    private int age;
    private boolean sex;
    @CreatedDate
    private Date createTime;
}
