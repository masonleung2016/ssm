package com.springboot.bcode.domain.auth;

import com.springboot.core.jdbc.annotation.Columns;
import com.springboot.core.jdbc.annotation.Tables;
import com.springboot.core.web.mvc.JqGridParam;

/**
 * 岗位表
 *
 * @Author: LCF
 * @Date: 2020/1/2 16:41
 * @Package: com.springboot.bcode.domain.auth
 */

@Tables(table = "t_web_job")
public class Job extends JqGridParam {

    // Fields
    @Columns(column = "id", primaryKey = true)
    private Integer id;
    @Columns(column = "name")
    private String name;
    @Columns(column = "state")
    private Integer state;
    @Columns(column = "sorts")
    private Integer sorts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSorts() {
        return sorts;
    }

    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
