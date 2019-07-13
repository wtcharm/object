package cn.com.objcet.api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.objcet.api.service.INewsObjcetService;
import cn.com.objcet.client.api.INewsRestContoller;
import cn.com.objcet.client.dto.NewsPage;
import cn.com.objcet.client.utils.RestRequest;
import cn.com.objcet.client.vo.News;

@Service
public class NewsObjcetServiceImpl implements INewsObjcetService {

	@Autowired
	private INewsRestContoller newsRestContoller;
	
	@Override
	public List<News> getNewsAll(RestRequest<NewsPage> reqbo) {
		// TODO Auto-generated method stub
		return this.newsRestContoller.getNewsListNews(reqbo);
	}

//	@Override
//	public List<News> getNewsAll(RestRequest<NewsPage> reqbo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
