package com.springboot.core.jdbc.page;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:19
 * @Package: com.springboot.core.jdbc.page
 */

public class MysqlSQLPageHandleImpl implements ISQLPageHandle {

    @Override
    public String handlerPagingSQL(String oldSQL, int pageNo, int pageSize) {
        StringBuffer sql = new StringBuffer(oldSQL);
        if (pageSize > 0) {
            int firstResult = (pageNo - 1) * pageSize;
            if (firstResult <= 0) {
                sql.append(" limit ").append(pageSize);
            } else {
                sql.append(" limit ").append(firstResult).append(",")
                        .append(pageSize);
            }
        }
        return sql.toString();
    }
}
