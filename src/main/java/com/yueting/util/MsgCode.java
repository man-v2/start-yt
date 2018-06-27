package com.yueting.util;


public enum MsgCode {
	SUCCESS(0, "成功"),
	FAILED(1, "服务器内部错误"),
	PARAMETER_FAILED(2, "参数不正确或参数格式不正确"),
	TOKEN_FAILED(3, "未授权的操作"),
	NOT_FIND_RECORD(4, "没找到记录");

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    MsgCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MsgCode getByCode(int code) {
        for (MsgCode codeEnum : MsgCode.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
        }

        return null;
    }
}
