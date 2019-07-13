package cn.com.objcet.api.service.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import cn.com.objcet.api.service.INewsObjcetService;
import cn.com.objcet.client.dto.NewsPage;
import cn.com.objcet.client.exception.DescribeException;
import cn.com.objcet.client.utils.ErrorUtil;
import cn.com.objcet.client.utils.RestRequest;
import cn.com.objcet.client.utils.StringUtils;
import cn.com.objcet.client.vo.News;
//@RequestMapping(value="/web/",produces ="application/json; charset=utf-8")
@RequestMapping(value="/web/")
@RestController
public class NewsController {
	public static final String DEPT_LIST_URL = "http://objcet-service:5080/api/v1/getAll";
	@Autowired
	private INewsObjcetService newsObjcetService;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/v1/newsList", method = RequestMethod.POST)
	public List<News> getNewsListNews(@Validated @RequestBody RestRequest<NewsPage> reqbo) {
		if(StringUtils.isEmpty(reqbo)) {
			throw new DescribeException(ErrorUtil.RESULT_FAIL, "缺少必要参数，请重新操作");
		}
		System.err.println(reqbo.body.getPageNum());
		List<News> listnews = this.newsObjcetService.getNewsAll(reqbo);
		return listnews;
	}

	@GetMapping("consumer/list")
	public Object  listDeptRest() {
		RestRequest<NewsPage> reqbo = new RestRequest<>();
		NewsPage body = new NewsPage("1","12","101");
		reqbo.setBody(body );

		return this.restTemplate.getForEntity(DEPT_LIST_URL, List.class);
		//		allDepts = this.restTemplate
		//				.exchange(DEPT_LIST_URL, HttpMethod.GET, new HttpEntity<Object>(this.headers), List.class).getBody();
		//		return allDepts;
	}

}
