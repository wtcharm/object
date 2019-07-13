package cn.com.objcet.client.api;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.objcet.client.dto.NewsPage;
import cn.com.objcet.client.utils.RestRequest;
import cn.com.objcet.client.vo.News;
@Component
@FeignClient(name = "objcet-service")
public interface INewsRestContoller {

	@RequestMapping(value = "/api/v1/newsAll", method = RequestMethod.POST)
	List<News> getNewsListNews(RestRequest<NewsPage> reqBo);

	@GetMapping(value = "/api/v1/getAll")
	List<News> getListAll();

	@PostMapping("/api/v1/add")
	boolean add(RestRequest<News> reqBo);

	@GetMapping("/api/v1/get")
	News get(RestRequest<Integer> reqBo);
}
