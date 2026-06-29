package com.reminder.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {

    private String responseStatus;
    private String responseMessage;
    private Object data;

}