package com.springboot.bcode.domain.logs;

import com.springboot.core.web.mvc.JqGridParam;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:51
 * @Package: com.springboot.bcode.domain.logs
 */

public class BLogVO extends JqGridParam {
    private String starttime;
    private String endtime;
    private String loginuser;
    private Integer state;

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(String loginuser) {
        this.loginuser = loginuser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
