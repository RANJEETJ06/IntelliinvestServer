package com.intelliinvest.server.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String email;
    private String FirstName;
    private String LastName;
    private Long MobileNo;
    private String Password;
    private String Country;
    private Integer PIN;
}
