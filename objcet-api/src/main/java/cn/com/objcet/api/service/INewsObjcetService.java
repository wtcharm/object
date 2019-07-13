package cn.com.objcet.api.service;

import java.util.List;
import cn.com.objcet.client.dto.NewsPage;
import cn.com.objcet.client.utils.RestRequest;
import cn.com.objcet.client.vo.News;

public interface INewsObjcetService {

	List<News> getNewsAll(RestRequest<NewsPage> reqbo);

}
