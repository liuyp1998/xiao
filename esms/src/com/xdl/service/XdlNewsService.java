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
    /** ���ݸ�����id �õ���Ӧ��ֱ���ӷ����б� */
    public  List<XdlNews>  subNewsList(){
    	return  newsDao.findAll();
    }
}
