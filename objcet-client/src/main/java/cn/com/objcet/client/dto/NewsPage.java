package cn.com.objcet.client.dto;

import java.io.Serializable;

public class NewsPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String pageNum ;//当前页
	public String pageSize ;//每页显示数据
	public String brand ; //品牌还是集团
	
	
	
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
	public NewsPage(String pageNum, String pageSize, String brand) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.brand = brand;
	}
	public NewsPage() {
		super();
	}
	
	

}
