package com.xdl.service;

import java.util.List;

import com.xdl.bean.XdlNews;
import com.xdl.dao.XdlNewsDAO;
import com.xdl.factory.XdlNewsDAOFactory;

public class XdlNewsService {
    private  XdlNewsDAO newsDao;
    public  XdlNewsService(){
    	newsDao = XdlNewsDAOFactory.getNewsDAO();
    }
    /** 根据父分类id 得到对应的直接子分类列表 */
    public  List<XdlNews>  subNewsList(){
    	return  newsDao.findAll();
    }
}
