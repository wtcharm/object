package cn.com.objcet.client.service;
import java.util.List;
import cn.com.objcet.client.vo.News;
public interface INewsService {
	
	/**
	 * 添加
	 * @param news 对象
	 * @return
	 */
	public boolean add(News news) ;
	/**
	 * 获取单个对象
	 * @param id
	 * @return
	 */
	public News get(Integer id) ;
	/**
	 * 获取所有
	 * @return
	 */
	public List<News> list() ;	
	
}
