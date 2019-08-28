package com.xdl.dao;

import java.util.List;

import com.xdl.bean.XdlCategory;

public interface XdlCategoryDAO {
    /** 根据父分类id 得到对应的直接子分类列表 */
	List<XdlCategory>   getCategoryListByParentId(int parent_id);
	/** 根据分类编号 获取分类对象 */
	XdlCategory   getCategoryByCategoryId(int  category_id);
}
