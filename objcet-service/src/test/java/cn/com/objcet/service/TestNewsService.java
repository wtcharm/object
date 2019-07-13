package cn.com.objcet.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.com.objcet.ServiceStartApplication;
import cn.com.objcet.client.dto.NewsPage;
import cn.com.objcet.client.utils.RestRequest;
import cn.com.objcet.service.contoller.NewsRestContoller;

@SpringBootTest(classes=ServiceStartApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestNewsService {
	@Autowired
private NewsRestContoller newsRestContoller;
	
	@Test
	public void testList() {
		RestRequest<NewsPage> reqbo = new RestRequest<NewsPage>();
		NewsPage body = new NewsPage();
		body.setPageNum("112");
		reqbo.setBody(body );
		System.err.println(this.newsRestContoller.getNewsListNews(reqbo ));
	}
}
