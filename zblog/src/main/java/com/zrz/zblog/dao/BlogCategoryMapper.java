package com.zrz.zblog.dao;

import com.zrz.zblog.entity.BlogCategory;
import com.zrz.zblog.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rongze Zhao
 * @date 2019-07-29 18:16
 */
@Component
public interface BlogCategoryMapper {

    BlogCategory selectByPrimaryKey(Integer categoryId);

    BlogCategory selectByCategoryName(String categoryName);

    List<BlogCategory> selectByCategoryIds(@Param("categoryIds") List<Integer> categoryIds);

    List<BlogCategory> findCategoryList(PageQueryUtil pageUtil);

    int getTotalCategories(PageQueryUtil pageUtil);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);

    int deleteByPrimaryKey(Integer categoryId);

    int deleteBatch(Integer[] ids);

}
