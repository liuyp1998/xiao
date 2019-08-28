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
    /** ���ݷ���id �õ���Ӧ��ֱ���ӷ����Ʒ�б� */
    public  List<XdlProduct>  subProductListByCategoryId(int category_id){
    	return  productDao.findProductByCategoryId(category_id);
    }
    /** ���ݷ�ҳ��Ϣ �õ������Ʒ�б� */
    public  List<XdlProduct>  subProductListByPageInfo(int category_id,
    	 String orderStd,String orderType,int pageSize,int pageNumber){
    	return  productDao.findProductByCategoryIdAndOrderStdAndOrderTypeAndPageSizeAndPageNumber
    		(category_id, orderStd, orderType, pageSize, pageNumber);
    }
}
