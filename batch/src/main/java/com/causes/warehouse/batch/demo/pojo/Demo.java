package com.causes.warehouse.batch.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo implements Serializable {

    private String id;
    private String name;
    private String age;
}
