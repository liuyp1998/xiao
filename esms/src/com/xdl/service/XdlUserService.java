package com.xdl.service;

import com.xdl.bean.XdlUser;
import com.xdl.dao.XdlUserDAO;
import com.xdl.factory.XdlUserDAOFactory;

public class XdlUserService {
	// 持有dao 的引用 
    private  XdlUserDAO  userDao;
    public  XdlUserService(){
    	//userDao = new XdlUserDAOOracleImpl();
    	// 使用工厂给dao 赋值 
    	userDao = XdlUserDAOFactory.getUserDAO();
    }
    /** 注册的业务方法  */
    public  boolean  register(XdlUser user){
    	return   userDao.insertXdlUser(user) == 1?true:false;
    }
    /** 登录的业务方法  */
    public  XdlUser  login(String  login_name,String password){
    	return   userDao.getXdlUserByLoginNameAndPassword(login_name, password);
    }
}
