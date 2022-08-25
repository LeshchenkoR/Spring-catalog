package me.leshchenkor.springcatalog.entity;

import lombok.Data;

@Data
public class BaseResponse {
    private int errorCode;
    private String errorMessage;

}
