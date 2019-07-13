package cn.com.objcet.service.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.objcet.client.vo.News;


@Mapper
public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);
    	
    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);
    
    News selectByIdAndNoDr(Integer id);
    //多个参数都是map String lordnews,String brand
	List<News> selectByLordnews(Map<String, String> map);
	// 按照发布时间 有大到小顺序排列
	List<News> selectByNewsAll(Map<String, Object> map);

	List<News> selectNewsAll();
	
    int updateByPrimaryKeySelective(News record);
    
    int updateByIdAndDr(News record);

    int updateByPrimaryKey(News record);
}