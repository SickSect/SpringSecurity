package com.boot.ugina.bootexmpl.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AuthRequest  {
    private String token;
    private String password;
    private String email;
}
