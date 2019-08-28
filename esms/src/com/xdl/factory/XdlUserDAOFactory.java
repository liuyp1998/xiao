package com.xdl.factory;

import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.impl.XdlUserDAOOracleImpl;

public class XdlUserDAOFactory {
    /** 静态工厂方法 */
	public  static  XdlUserDAO getUserDAO(){
		return  new XdlUserDAOOracleImpl();
		// 其实这里可以读取 配置文件  把包名 + 类名写入配置文件
		// 读取到包名+类名 通过反射来创建对象 "com.xdl.dao.impl.XdlUserDAOOracleImpl"
	}
}
