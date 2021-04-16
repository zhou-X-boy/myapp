package com.example.myapp.entity;

/**
 * @author 25798
 */
public class LoginResponse {

    /**
     * result
     */
    private String result;
    /**
     * data
     */
    private  DataDTO data;
    private  String  msg;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public  DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static class DataDTO {
        /**
         * id
         */
        private int id;
        /**
         * name
         */
        private String name;
        /**
         * role
         */
        private int role;
        /**
         * status
         */
        private int status;
        /**
         * token
         */
        private String token;
        /**
         * md_tags
         */
        private Object md_tags;
        /**
         * regist_date
         */
        private Object regist_date;
        /**
         * last_login
         */
        private int last_login;
        /**
         * index_page
         */
        private Object index_page;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getMd_tags() {
            return md_tags;
        }

        public void setMd_tags(Object md_tags) {
            this.md_tags = md_tags;
        }

        public Object getRegist_date() {
            return regist_date;
        }

        public void setRegist_date(Object regist_date) {
            this.regist_date = regist_date;
        }

        public int getLast_login() {
            return last_login;
        }

        public void setLast_login(int last_login) {
            this.last_login = last_login;
        }

        public Object getIndex_page() {
            return index_page;
        }

        public void setIndex_page(Object index_page) {
            this.index_page = index_page;
        }
    }
}
