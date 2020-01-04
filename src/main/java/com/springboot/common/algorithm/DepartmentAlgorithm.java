package com.springboot.common.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.springboot.bcode.domain.auth.Department;

/**
 * 部门类相关算法
 *
 * @Author: LCF
 * @Date: 2020/1/2 17:06
 * @Package: com.springboot.common.algorithm
 */

public class DepartmentAlgorithm {

    /**
     * 去重复
     *
     * @param @param allList 设定文件
     * @return void 返回类型
     *
     */
	/*public static void mergeRepeat(List<Department> allList) {
		if (allList == null || allList.isEmpty()) {
			return;
		}
		Set<Department> ownedSet = new HashSet<Department>();
		for (Department dept : allList) {
			ownedSet.add(dept);
		}
		allList = new ArrayList<Department>(ownedSet);
	}*/

    /**
     * 递归将数据tree存储结构
     *
     * @param @param allList
     * @param @return 设定文件
     * @return List<Department> 返回类型
     *
     */
    public static List<Department> tree(List<Department> allList) {
        if (allList == null || allList.isEmpty()) {
            return null;
        }
        Collections.sort(allList);
        List<Department> tree = new ArrayList<Department>();
        for (Department node : allList) {
            if (node.isRoot()) {
                // 遍历根节点
                buildTreeNode(node, allList);
                tree.add(node);
            }
        }
        return tree;
    }

    /**
     * 构建下级菜单
     *
     * @param node
     */
    private static void buildTreeNode(Department node, List<Department> allList) {
        List<Department> childrens = null;
        for (Department child : allList) {
            // 获取子节点
            if (node.getId().equals(child.getParentId())) {
                if (null == childrens) {
                    childrens = new ArrayList<Department>();
                }
                childrens.add(child);
                buildTreeNode(child, allList);
            }
        }
        if (null != childrens && !childrens.isEmpty()) {
            Collections.sort(childrens);
            node.setChildrens(childrens);
        }
    }

    /**
     * 根据部门id查找所有下级部门(包含当前部门)
     *
     * @param @param id
     * @param @return 设定文件
     * @return List<Department> 返回类型
     *
     */
    public static List<Department> findSelfAndAllChild(Integer id,
                                                       List<Department> allList) {
        if (allList == null || allList.isEmpty() || id == null) {
            return null;
        }
        Department current = null;
        for (Department dept : allList) {
            if (dept.getId().equals(id)) {
                current = dept;
                break;
            }
        }
        if (current == null) {
            return null;
        }
        List<Department> resultList = findAllChild(current, allList);
        if (resultList == null) {
            resultList = new ArrayList<Department>();
        }
        resultList.add(current);
        return resultList;
    }

    /**
     * 根据部门id查找所有下级部门
     *
     * @param @param id
     * @param @return 设定文件
     * @return List<Department> 返回类型
     *
     */
    public static List<Department> findAllChild(Integer id,
                                                List<Department> allList) {
        if (allList == null || allList.isEmpty() || id == null) {
            return null;
        }
        Department current = null;
        for (Department dept : allList) {
            if (dept.getId().equals(id)) {
                current = dept;
                break;
            }
        }
        return findAllChild(current, allList);
    }

    /**
     * 根据部门查找所有下级部门
     *
     * @param @param id
     * @param @return 设定文件
     * @return List<Department> 返回类型
     *
     */
    public static List<Department> findAllChild(Department current,
                                                List<Department> allList) {
        if (allList == null || allList.isEmpty() || current == null) {
            return null;
        }
        List<Department> resultList = new ArrayList<Department>();
        for (Department dept : allList) {
            if (dept.getParentId().equals(current.getId())) {

                resultList.add(dept);
                resultList.addAll(findAllChild(dept, allList));
            }
        }
        return resultList;
    }

}
