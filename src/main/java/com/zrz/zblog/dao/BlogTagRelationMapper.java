package com.zrz.zblog.dao;

import com.zrz.zblog.entity.BlogTagRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Rongze Zhao
 * @date 2019-07-29 19:42
 */
public interface BlogTagRelationMapper {

    BlogTagRelation selectByBlogIdAndTagId(@Param("blogId") Long blogId, @Param("tagId") Integer tagId);

    List<Long> selectDistinctTagIds(Integer[] tagIds);

    BlogTagRelation selectByPrimaryKey(Long relationId);


    int insert(BlogTagRelation record);

    int insertSelective(BlogTagRelation record);

    int batchInsert(@Param("relationList") List<BlogTagRelation> blogTagRelationList);


    int updateByPrimaryKeySelective(BlogTagRelation record);

    int updateByPrimaryKey(BlogTagRelation record);

    int deleteByPrimaryKey(Long relationId);

    int deleteByBlogId(Long blogId);

}
