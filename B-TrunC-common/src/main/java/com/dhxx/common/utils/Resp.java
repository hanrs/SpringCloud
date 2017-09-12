package com.dhxx.common.utils;


import com.dhxx.common.message.ResponseMessage;

public class Resp {
	
    public static ResponseMessage SUCCESS() {
        return new ResponseMessage();
    }

    public static ResponseMessage SUCCESS(Object result) {
        return new ResponseMessage(result);
    }
}
