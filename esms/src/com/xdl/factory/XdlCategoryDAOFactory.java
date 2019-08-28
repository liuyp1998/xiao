package com.xdl.factory;

import com.xdl.dao.XdlCategoryDAO;
import com.xdl.dao.impl.XdlCategoryDAOOracleImpl;

public class XdlCategoryDAOFactory {
    public  static  XdlCategoryDAO  getCategoryDAO(){
    	return new  XdlCategoryDAOOracleImpl();
    }
}
