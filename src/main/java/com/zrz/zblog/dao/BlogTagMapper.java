package com.zrz.zblog.dao;

import com.zrz.zblog.entity.BlogTag;
import com.zrz.zblog.entity.BlogTagCount;
import com.zrz.zblog.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogTagMapper {

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    int getTotalTags(PageQueryUtil pageUtil);

    List<BlogTagCount> getTagCount();

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    int batchInsertBlogTag(List<BlogTag> tagList);


    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);


    int deleteByPrimaryKey(Integer tagId);

    int deleteBatch(Integer[] ids);

}
