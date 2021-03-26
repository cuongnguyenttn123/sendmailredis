package com.github.sonus21.task.executor.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Employee {
    private Integer id;
    private String name;
    private String address;
}
