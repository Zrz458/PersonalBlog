package com.zrz.zblog.dao;

import com.zrz.zblog.entity.File;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Rongze Zhao
 * @date 2019-07-30 13:21
 */
@Component
public class FileDAO {

    @Resource
    private MongoTemplate mongoTemplate;

    public boolean saveFile(File file){
        return mongoTemplate.save(file)!=null;
    }

    public File findFileByName(String name){
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query,File.class);
    }

}
