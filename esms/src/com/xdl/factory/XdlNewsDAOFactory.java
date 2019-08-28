package com.xdl.factory;

import com.xdl.dao.XdlNewsDAO;
import com.xdl.dao.impl.XdlNewsDAOOracleImpl;

public class XdlNewsDAOFactory {
    public  static  XdlNewsDAO  getNewsDAO(){
    	return new  XdlNewsDAOOracleImpl();
    }
}
