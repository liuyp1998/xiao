package com.xdl.dao;

import java.util.List;

import com.xdl.bean.XdlProduct;

public interface XdlProductDAO {
    /** ���ݷ����� ��ѯ���еĲ�Ʒ*/
	List<XdlProduct>  findProductByCategoryId(int category_id);
	/** ����ĳ������ı��  �Լ�ĳ�������׼  ĳ������ʽ  һҳ��ʾ������  
	 * �Լ��ڼ�ҳ���� */
	List<XdlProduct>  findProductByCategoryIdAndOrderStdAndOrderTypeAndPageSizeAndPageNumber
	   (int category_id,String orderStd,String orderType,int pageSize,
	    int  pageNumber);
}
