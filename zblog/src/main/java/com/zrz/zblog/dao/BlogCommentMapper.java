package com.zrz.zblog.dao;


import com.zrz.zblog.entity.BlogComment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BlogCommentMapper {

    BlogComment selectByPrimaryKey(Long commentId);

    List<BlogComment> findBlogCommentList(Map map);

    int getTotalBlogComments(Map map);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);

    int deleteByPrimaryKey(Long commentId);

    int checkDone(Integer[] ids);

    int deleteBatch(Integer[] ids);

}