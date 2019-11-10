package com.zrz.zblog.entity;

import org.bson.types.Binary;
import java.util.Date;

/**
 * @author Rongze Zhao
 * @date 2019-07-24 12:10
 */
public class File {

    private String id;
    private String name; // 文件名称
    private String contentType; // 文件类型
    private long size;
    private Date uploadDate;
    private Binary content; // 文件内容
    private String path; // 文件路径

    public File() {
    }

    public File(String name, String contentType, long size, Date uploadDate, Binary content) {
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.uploadDate = uploadDate;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Binary getContent() {
        return content;
    }

    public void setContent(Binary content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
