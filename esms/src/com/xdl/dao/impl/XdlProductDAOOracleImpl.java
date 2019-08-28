package com.xdl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xdl.bean.XdlProduct;
import com.xdl.dao.XdlProductDAO;
import com.xdl.util.DbcpUtil;

public class XdlProductDAOOracleImpl implements XdlProductDAO {

	@Override
	public List<XdlProduct> findProductByCategoryId(int category_id) {
		Connection  conn = null;
		PreparedStatement  ps = null;
        ResultSet  rs = null;
        List<XdlProduct>  datas = new ArrayList<XdlProduct>();
        conn = DbcpUtil.getConnection();
        String sql = "select p.* from xdl_product p,xdl_category_product cp where "
        		+ "p.product_id = cp.product_id and cp.category_id = ?";
        try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			rs = ps.executeQuery();
			while(rs.next()){
				XdlProduct  product = new XdlProduct();
				product.setProduct_id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setPicture(rs.getString("picture"));
				product.setPublish_time(rs.getTimestamp("publish_time"));
				product.setFixed_price(rs.getDouble("fixed_price"));
				product.setLower_price(rs.getDouble("lower_price"));
				product.setAuthor(rs.getString("author"));
				product.setPublishing(rs.getString("publishing"));
				product.setPrint_number(rs.getInt("print_number"));
				datas.add(product);
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
	public List<XdlProduct> findProductByCategoryIdAndOrderStdAndOrderTypeAndPageSizeAndPageNumber(int category_id,
			String orderStd, String orderType, int pageSize, int pageNumber) {
		Connection  conn = null;
		PreparedStatement  ps = null;
        ResultSet  rs = null;
        List<XdlProduct>  datas = new ArrayList<XdlProduct>();
        conn = DbcpUtil.getConnection();
        // 最内层负责 排序 
        String sql = "select p.* from xdl_product p,xdl_category_product cp where "
        		+ "p.product_id = cp.product_id and cp.category_id = ? order by "
        		+ orderStd +" " + orderType;
        // 中间层 负责编号  起别名 和 部分过滤 
        sql = "select rownum r,t.* from (" + sql + ") t where rownum  < ?";
        // 最外层负责 使用别名r 进行大于的过滤 
        sql = "select * from (" + sql + ") where  r > ?";
        try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category_id);
			ps.setInt(2, (pageNumber * pageSize)+1);
			ps.setInt(3, (pageNumber-1) * pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				XdlProduct  product = new XdlProduct();
				product.setProduct_id(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setPicture(rs.getString("picture"));
				product.setPublish_time(rs.getTimestamp("publish_time"));
				product.setFixed_price(rs.getDouble("fixed_price"));
				product.setLower_price(rs.getDouble("lower_price"));
				product.setAuthor(rs.getString("author"));
				product.setPublishing(rs.getString("publishing"));
				product.setPrint_number(rs.getInt("print_number"));
				datas.add(product);
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





