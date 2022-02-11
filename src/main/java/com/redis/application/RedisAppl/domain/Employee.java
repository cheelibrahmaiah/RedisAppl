package com.redis.application.RedisAppl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private Double salary;
}
