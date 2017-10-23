package com.motorsc.match.common.tool;

import java.io.Serializable;

/**
 * 基本返回消息类
 *
 * @author LiJiaShu
 */
public class BaseResult implements Serializable {

        private static final long serialVersionUID = -3938516549044519709L;

        private boolean result; // 操作结果

        /**
         * message（消息）
         */
        private String message; // 操作结果信息说明

        /**
         * 状态码
         */
        private int code; // 代码

        public BaseResult() {
        }

        public BaseResult(boolean result, String message, int code) {
                this.result = result;
                this.message = message;
                this.code = code;
        }

        public boolean isResult() {
                return result;
        }

        public void setResult(boolean result) {
                this.result = result;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }

        public static BaseResult getBaseSuccessInstance(String message, int code) {
                return new BaseResult(true, message, code);
        }

        public static BaseResult getBaseSuccessInstance(String message) {
                return new BaseResult(true, message, 0);
        }

        public static BaseResult getBaseFailureInstatce(String message, int code) {
                return new BaseResult(false, message, code);
        }
}
