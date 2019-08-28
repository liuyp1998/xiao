package com.xdl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlNews;
import com.xdl.dao.XdlNewsDAO;
import com.xdl.util.DbcpUtil;

public class XdlNewsDAOOracleImpl implements XdlNewsDAO {

	@Override
	public List<XdlNews> findAll() {
		Connection  conn = null;
		PreparedStatement  ps = null;
		ResultSet  rs = null;
		conn = DbcpUtil.getConnection();
		List<XdlNews>  datas = new ArrayList<XdlNews>();
		String  sql = "select * from  xdl_news order by release_time desc";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				XdlNews  news = new XdlNews(rs.getInt("id"),rs.getString("title") 
					, rs.getString("content"), rs.getTimestamp("release_time"),
					rs.getString("sticky"));
				datas.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcpUtil.realeaseResource(conn, ps, rs);
		}
		return datas;
	}

}
