package com.xdl.dao;

import com.xdl.bean.XdlUser;

public interface XdlUserDAO {
    /** ���û���Ϣ �������ݿ�   ���� int  ����0 ����洢ʧ�� ����1 ����ɹ� */
	int  insertXdlUser(XdlUser  user);
	/** ���ݵ�¼��  �� ���� ��ѯһ���û� ���ɹ����� null �ɹ�����XdlUser���� */
	XdlUser  getXdlUserByLoginNameAndPassword(String  login_name,
		String password);
}
