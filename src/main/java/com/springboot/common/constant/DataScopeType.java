package com.springboot.common.constant;

/**
 * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门及以下数据权限4：本部门数据权限 5：本人）
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:09
 * @Package: com.springboot.common.constant
 */

@SuppressWarnings("ALL")
public class DataScopeType {

    public static final Integer ALL=1;
    //全部数据权限

    public static final Integer CUSTOMIZE=2;
    //自定数据权限

    public static final Integer DEPTANDBELOW=3;
    //本部门及以下数据权限

    public static final Integer DEPT=4;
    //本部门数据权限

    public static final Integer SELF=5;
    //本人


}
