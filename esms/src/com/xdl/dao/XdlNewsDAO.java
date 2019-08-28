package com.xdl.dao;

import java.util.List;

import com.xdl.bean.XdlNews;

public interface XdlNewsDAO {
    List<XdlNews>  findAll();
}
