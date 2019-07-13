package cn.com.objcet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.objcet.client.service.INewsService;
import cn.com.objcet.client.vo.News;
import cn.com.objcet.service.mapper.NewsMapper;
@Service
public class NewsServiceImpl implements INewsService {
	
	@Autowired
	private NewsMapper newsMapper;
	
	@Override
	public boolean add(News news) {
		// TODO Auto-generated method stub
		return this.newsMapper.insertSelective(news) > 0 ? true :false;
	}

	@Override
	public News get(Integer id) {
		// TODO Auto-generated method stub
		return this.newsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<News> list() {
		// TODO Auto-generated method stub
		return this.newsMapper.selectNewsAll();
	}

}
