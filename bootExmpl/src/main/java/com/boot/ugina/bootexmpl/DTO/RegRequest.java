package com.boot.ugina.bootexmpl.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RegRequest {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private Integer age;
}
