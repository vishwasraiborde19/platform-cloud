package com.platform.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String id;
    private String name;
    private String email;
}
