package com.xecurity.security_amo.response;

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
    private String email;
    private String password;
    private Integer age;
}
