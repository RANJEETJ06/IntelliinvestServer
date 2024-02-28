package com.intelliinvest.server.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private Integer value;

    public ApiResponse(String message, boolean success,Integer value) {
        this.message=message;
        this.success=success;
        this.value=value;
    }
}
