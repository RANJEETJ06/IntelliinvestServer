package com.intelliinvest.server.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer Id;
    private String Title;
    private String Desc;
    private Integer Price;
}
