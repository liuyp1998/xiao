package com.xdl.bean;

import java.io.Serializable;

public class XdlCategory implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "XdlCategory [category_id=" + category_id + ", name=" + name + ", turn=" + turn + ", description="
				+ description + ", parent_id=" + parent_id + "]\n";
	}
	public XdlCategory(int category_id, String name, int turn, String description, int parent_id) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.turn = turn;
		this.description = description;
		this.parent_id = parent_id;
	}
	public XdlCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	private  int  category_id;
    private  String name;
    /** 显示的序号 可以用来排序 */
    private  int   turn;
    private  String  description;
    /** 父分类的分类编号 */
    private  int    parent_id;
}
