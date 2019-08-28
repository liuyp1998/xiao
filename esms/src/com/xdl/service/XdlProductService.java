package com.xdl.service;

import java.util.List;

import com.xdl.bean.XdlProduct;
import com.xdl.dao.XdlProductDAO;
import com.xdl.factory.XdlProductDAOFactory;

public class XdlProductService {
    private  XdlProductDAO productDao;
    public  XdlProductService(){
    	productDao = XdlProductDAOFactory.getProductDAO();
    }
    /** 根据分类id 得到对应的直接子分类产品列表 */
    public  List<XdlProduct>  subProductListByCategoryId(int category_id){
    	return  productDao.findProductByCategoryId(category_id);
    }
    /** 根据分页信息 得到分类产品列表 */
    public  List<XdlProduct>  subProductListByPageInfo(int category_id,
    	 String orderStd,String orderType,int pageSize,int pageNumber){
    	return  productDao.findProductByCategoryIdAndOrderStdAndOrderTypeAndPageSizeAndPageNumber
    		(category_id, orderStd, orderType, pageSize, pageNumber);
    }
}
