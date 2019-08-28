package com.xdl.test;

import java.util.List;

import com.xdl.bean.XdlCategory;
import com.xdl.service.XdlCategoryService;

public class XdlCategoryServiceTest {

	public static void main(String[] args) {
		XdlCategoryService xcs = new XdlCategoryService();
		List<XdlCategory>  datas = xcs.subCategoryList(1);
		System.out.println(datas);

	}

}
