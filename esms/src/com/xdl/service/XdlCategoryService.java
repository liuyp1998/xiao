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
    /** 根据父分类id 得到对应的直接子分类列表 */
    public  List<XdlCategory>  subCategoryList(int parent_id){
    	return  categoryDao.getCategoryListByParentId(parent_id);
    }
    /** 根据分类id  获取分类对象 */
    public  XdlCategory     categoryInfoByCategoryId(int category_id){
    	return   categoryDao.getCategoryByCategoryId(category_id);
    }
}
