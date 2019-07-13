package cn.com.objcet.client.bo;

import java.io.Serializable;

public class DemoPageBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1693336074520866485L;
	
	String pageNum;
	String pageSize;
	String brand;
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	

}
