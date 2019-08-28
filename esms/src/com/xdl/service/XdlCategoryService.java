package com.xdl.service;

import java.util.List;

import com.xdl.bean.XdlCategory;
import com.xdl.dao.XdlCategoryDAO;
import com.xdl.factory.XdlCategoryDAOFactory;

public class XdlCategoryService {
    private  XdlCategoryDAO categoryDao;
    public  XdlCategoryService(){
    	categoryDao = XdlCategoryDAOFactory.getCategoryDAO();
    }
    /** ���ݸ�����id �õ���Ӧ��ֱ���ӷ����б� */
    public  List<XdlCategory>  subCategoryList(int parent_id){
    	return  categoryDao.getCategoryListByParentId(parent_id);
    }
    /** ���ݷ���id  ��ȡ������� */
    public  XdlCategory     categoryInfoByCategoryId(int category_id){
    	return   categoryDao.getCategoryByCategoryId(category_id);
    }
}
