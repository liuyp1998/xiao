package com.xdl.test;

import java.util.List;

import com.xdl.bean.XdlNews;
import com.xdl.service.XdlNewsService;

public class XdlNewsServiceTest {

	public static void main(String[] args) {
		XdlNewsService xcs = new XdlNewsService();
		List<XdlNews>  datas = xcs.subNewsList();
		System.out.println(datas);

	}

}
