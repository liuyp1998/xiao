package com.xdl.factory;

import com.xdl.dao.XdlProductDAO;
import com.xdl.dao.impl.XdlProductDAOOracleImpl;

public class XdlProductDAOFactory {
    public  static  XdlProductDAO  getProductDAO(){
    	return new  XdlProductDAOOracleImpl();
    }
}
