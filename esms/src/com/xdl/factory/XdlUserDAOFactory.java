package com.xdl.factory;

import com.xdl.dao.XdlUserDAO;
import com.xdl.dao.impl.XdlUserDAOOracleImpl;

public class XdlUserDAOFactory {
    /** ��̬�������� */
	public  static  XdlUserDAO getUserDAO(){
		return  new XdlUserDAOOracleImpl();
		// ��ʵ������Զ�ȡ �����ļ�  �Ѱ��� + ����д�������ļ�
		// ��ȡ������+���� ͨ���������������� "com.xdl.dao.impl.XdlUserDAOOracleImpl"
	}
}
