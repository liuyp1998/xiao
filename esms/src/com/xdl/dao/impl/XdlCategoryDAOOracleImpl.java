package com.xdl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xdl.bean.XdlCategory;
import com.xdl.dao.XdlCategoryDAO;
import com.xdl.util.DbcpUtil;

public class XdlCategoryDAOOracleImpl implements XdlCategoryDAO {

	@Override
	public List<XdlCategory> getCategoryListByParentId(int parent_id) {
		Connection  conn = null;
		PreparedStatement  ps = null;
		ResultSet  rs = null;
		conn = DbcpUtil.getConnection();
		List<XdlCategory>  datas = new ArrayList<XdlCategory>();
		String  sql = "select * from  xdl_category where parent_id = ? order by turn";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, parent_id);
			rs = ps.executeQuery();
			while(rs.next()){
				XdlCategory  category = new XdlCategory(rs.getInt("category_id"),
					rs.getString("name"), rs.getInt("turn"), rs.getString("description"),
				    rs.getInt("parent_id"));
				datas.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcpUtil.realeaseResource(conn, ps, rs);
		}
		return datas;
	}

	@Override
	public XdlCategory getCategoryByCategoryId(int category_id) {
		Connection  conn = null;
		PreparedStatement  ps = null;
		ResultSet  rs = null;
		conn = DbcpUtil.getConnection();
		String  sql = "select * from  xdl_category where category_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			rs = ps.executeQuery();
			if(rs.next()){
				XdlCategory  category = new XdlCategory(rs.getInt("category_id"),
					rs.getString("name"), rs.getInt("turn"), rs.getString("description"),
				    rs.getInt("parent_id"));
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcpUtil.realeaseResource(conn, ps, rs);
		}
		return null;
	}

}
