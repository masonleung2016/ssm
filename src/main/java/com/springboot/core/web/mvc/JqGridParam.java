package com.springboot.core.web.mvc;

/**
 * jqGrid请求参数
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:54
 * @Package: com.springboot.core.web.mvc
 */

public class JqGridParam {
    private int page;
    // 当前页
    private int limit;
    // 分页步长
    private String sidx;
    // 排序 字段
    private String sord;
    // asc 或 desc

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

}
