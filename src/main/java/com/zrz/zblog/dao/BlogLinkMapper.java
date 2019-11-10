package com.zrz.zblog.dao;

import com.zrz.zblog.entity.BlogLink;
import com.zrz.zblog.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogLinkMapper {

    BlogLink selectByPrimaryKey(Integer linkId);

    List<BlogLink> findLinkList(PageQueryUtil pageUtil);

    int getTotalLinks(PageQueryUtil pageUtil);

    int insert(BlogLink record);

    int insertSelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);

    int updateByPrimaryKeySelective(BlogLink record);

    int deleteByPrimaryKey(Integer linkId);


    int deleteBatch(Integer[] ids);
}