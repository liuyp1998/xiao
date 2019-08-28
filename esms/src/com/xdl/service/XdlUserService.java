package com.xdl.service;

import com.xdl.bean.XdlUser;
import com.xdl.dao.XdlUserDAO;
import com.xdl.factory.XdlUserDAOFactory;

public class XdlUserService {
	// ����dao ������ 
    private  XdlUserDAO  userDao;
    public  XdlUserService(){
    	//userDao = new XdlUserDAOOracleImpl();
    	// ʹ�ù�����dao ��ֵ 
    	userDao = XdlUserDAOFactory.getUserDAO();
    }
    /** ע���ҵ�񷽷�  */
    public  boolean  register(XdlUser user){
    	return   userDao.insertXdlUser(user) == 1?true:false;
    }
    /** ��¼��ҵ�񷽷�  */
    public  XdlUser  login(String  login_name,String password){
    	return   userDao.getXdlUserByLoginNameAndPassword(login_name, password);
    }
}
