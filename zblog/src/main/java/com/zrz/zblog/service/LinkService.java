package com.zrz.zblog.service;


import com.zrz.zblog.entity.BlogLink;
import com.zrz.zblog.util.PageQueryUtil;
import com.zrz.zblog.util.PageResult;

import java.util.List;
import java.util.Map;

public interface LinkService {
    /**
     * 查询友链的分页数据
     */
    PageResult getBlogLinkPage(PageQueryUtil pageUtil);

    int getTotalLinks();

    Boolean saveLink(BlogLink link);

    BlogLink selectById(Integer id);

    Boolean updateLink(BlogLink tempLink);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回友链页面所需的所有数据(根据linkType分类)
     * @return Map<linkType,List<BlogLink>>
     */
    Map<Byte, List<BlogLink>> getLinksForLinkPage();
}
