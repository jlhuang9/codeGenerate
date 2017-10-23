package com.motorsc.match.common.tool;

import java.util.List;

/**
 * 基本分页返回消息类
 *
 * @param <T>
 * @author LiJiaShu
 */
public class ListResult<T> extends BaseResult {

        /**
         *
         */
        private static final long serialVersionUID = 5477694206576534093L;

        private List<T> listData;

        public List<T> getListData() {
                return listData;
        }

        public void setListData(List<T> listData) {
                this.listData = listData;
        }

        public static <T> ListResult<T> getListSuccessInstance(List<T> data, String msg, int code) {
                ListResult<T> r = new ListResult<T>();
                r.setResult(true);
                r.setMessage(msg);
                r.setCode(code);
                r.setListData(data);
                return r;
        }

        public static <T> ListResult<T> getListSuccessInstance(List<T> data, String msg) {
                ListResult<T> r = new ListResult<T>();
                r.setResult(true);
                r.setMessage(msg);
                r.setCode(0);
                r.setListData(data);
                return r;
        }

        public static <T> ListResult<T> getListFailureInstance(String msg, int code) {
                ListResult<T> r = new ListResult<T>();
                r.setResult(false);
                r.setMessage(msg);
                r.setCode(code);
                return r;
        }
}
