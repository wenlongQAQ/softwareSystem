package com.zzut.softwaresystem.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Component
public class User implements Serializable {
    private Long id;
    private String username;
    private String name;
    private String password;
    private String address;
    private String idNumber;
    private String telephone;
    private String sex;
    private String tag;
    private Integer identity;
    private Integer status;
}
