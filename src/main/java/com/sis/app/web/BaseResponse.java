package com.sis.app.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    private boolean success;
    private String messages;
    private Object data;
    private Object additionalEntity;

    public BaseResponse(boolean success, String messages, Object data) {
        this.success = success;
        this.messages = messages;
        this.data = data;
    }
}
