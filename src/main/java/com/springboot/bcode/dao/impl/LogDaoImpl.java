package com.springboot.bcode.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bcode.dao.LogDao;
import com.springboot.bcode.domain.logs.BLog;
import com.springboot.bcode.domain.logs.BLogVO;
import com.springboot.common.utils.StringUtils;
import com.springboot.core.jdbc.BaseDaoImpl;
import com.springboot.core.web.mvc.JqGridPage;

/**
 * @Author: LCF
 * @Date: 2020/1/2 16:22
 * @Package: com.springboot.bcode.dao.impl
 */

@Repository
public class LogDaoImpl extends BaseDaoImpl implements LogDao {

    @Override
    public JqGridPage<BLog> selectPage(BLogVO log) {

        List<BLog> list = super.select(
                getSqlPageHandle().handlerPagingSQL(logPageSql(log, 0),
                        log.getPage(), log.getLimit()), null, BLog.class);
        int count = super.jdbcTemplate.queryForObject(logPageSql(log, 1), null,
                Integer.class);
        JqGridPage<BLog> page = new JqGridPage<BLog>(list, count,
                log.getLimit(), log.getPage());
        return page;
    }

    private String logPageSql(BLogVO log, int type) {
        StringBuilder sql = new StringBuilder();
        if (type == 0) {
            sql.append("select  id,loginuser,vsername,title,url,request_method as requestmethod,content_type as contentType,request_params as requestparams,ip,createtime,duration,response_result as result,state from t_web_logs");
        } else {
            sql.append("select count(*) from t_web_logs ");
        }
        sql.append(" where 1=1");

        sql.append(" and createtime >='" + log.getStarttime() + "'");

        sql.append(" and createtime <='" + log.getEndtime() + "'");

        if (StringUtils.isNotBlank(log.getLoginuser())) {
            sql.append(" and loginuser like '%").append(
                    log.getLoginuser().trim() + "%' ");
        }
        if (log.getState() != null) {
            sql.append(" and state=" + log.getState() + "");
        }

        if (type == 0) {
            sql.append(" order by createtime desc");
        }
        return sql.toString();
    }

    @Override
    public int insert(BLog log) {
        return super.insert(log);
    }

}
