package com.xdl.dao;

import java.util.List;

import com.xdl.bean.XdlCategory;

public interface XdlCategoryDAO {
    /** ���ݸ�����id �õ���Ӧ��ֱ���ӷ����б� */
	List<XdlCategory>   getCategoryListByParentId(int parent_id);
	/** ���ݷ����� ��ȡ������� */
	XdlCategory   getCategoryByCategoryId(int  category_id);
}
