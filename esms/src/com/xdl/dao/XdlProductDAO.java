package com.xdl.dao;

import java.util.List;

import com.xdl.bean.XdlProduct;

public interface XdlProductDAO {
    /** 根据分类编号 查询所有的产品*/
	List<XdlProduct>  findProductByCategoryId(int category_id);
	/** 根据某个分类的编号  以及某个排序标准  某个排序方式  一页显示多少条  
	 * 以及第几页数据 */
	List<XdlProduct>  findProductByCategoryIdAndOrderStdAndOrderTypeAndPageSizeAndPageNumber
	   (int category_id,String orderStd,String orderType,int pageSize,
	    int  pageNumber);
}
