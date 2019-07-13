package cn.com.objcet.service.contoller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cn.com.objcet.client.api.INewsRestContoller;
import cn.com.objcet.client.dto.NewsPage;
import cn.com.objcet.client.service.INewsService;
import cn.com.objcet.client.utils.RestRequest;
import cn.com.objcet.client.vo.News;
@RestController
public class NewsRestContoller implements INewsRestContoller {

	@Autowired
	private INewsService newsService;

	@Override
	public List<News> getNewsListNews(@RequestBody RestRequest<NewsPage> reqBo) {
		return this.newsService.list();
	}

	@Override
	public List<News> getListAll() {
		// TODO Auto-generated method stub
		return this.newsService.list();
	}

	@Override
	public boolean add(RestRequest<News> reqBo) {
		// TODO Auto-generated method stub
		return this.newsService.add(reqBo.getBody());
	}

	@Override
	public News get(RestRequest<Integer> reqBo) {
		// TODO Auto-generated method stub
		return this.newsService.get(reqBo.getBody());
	}
	
	
}
