package com.zrz.zblog.entity;

/**
 * @author Rongze Zhao
 * @date 2019-07-29 19:23
 */
public class BlogTagCount {

    private Integer tagId;

    private String tagName;

    private Integer tagCount;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

}
