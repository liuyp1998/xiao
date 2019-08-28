package com.xdl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xdl.bean.XdlUser;
import com.xdl.dao.XdlUserDAO;
import com.xdl.util.DbcpUtil;
import com.xdl.util.Md5Util;

public class XdlUserDAOOracleImpl implements XdlUserDAO {

	@Override
	public int insertXdlUser(XdlUser user) {
		Connection  conn = null;
		PreparedStatement  ps = null;
        //1.加载驱动  和 2 获取连接 
		conn = DbcpUtil.getConnection();
		//3.定义sql 创建sql执行环境
		String  sql = "insert into xdl_user(user_id,login_name,password,email,"
				+ "recommender) values(xdl_user_user_id_seq.nextval,?,?,?,?)";
		try {
			//ps = conn.prepareStatement(sql);
			String[]  ids = {"user_id"};
			ps = conn.prepareStatement(sql, ids);
			ps.setString(1, user.getLogin_name());
			//ps.setString(2, user.getPassword());
			ps.setString(2, Md5Util.md5StrSalt(user.getPassword(),
				user.getLogin_name() )); 
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getRecommender());
			// 4.执行sql  处理执行结果 
			int  rows = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
			   System.out.println("主键值是:"+rs.getInt(1) );
			}
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// 5.释放资源 
			DbcpUtil.realeaseResource(conn, ps, null);
		}
		return 0;
	}

	@Override
	public XdlUser getXdlUserByLoginNameAndPassword(String login_name, String password) {
		Connection  conn = null;
		PreparedStatement  ps = null;
		ResultSet  rs = null;
		// 1.加载驱动  2.获取连接
		conn = DbcpUtil.getConnection();
		// 3. 编写sql  获取 sql 执行环境 
		String  sql = "select * from xdl_user where login_name=? and password = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, login_name);
			ps.setString(2, Md5Util.md5StrSalt(password,login_name));
			// 4.执行sql  遍历结果集 处理数据
			rs = ps.executeQuery();
			if(rs.next()){
				XdlUser  user = new XdlUser(rs.getInt("user_id"),
					rs.getString("login_name"), rs.getString("password"),
					rs.getString("email"), rs.getString("recommender"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbcpUtil.realeaseResource(conn, ps, rs);
		}
		
		return null;
	}

}



