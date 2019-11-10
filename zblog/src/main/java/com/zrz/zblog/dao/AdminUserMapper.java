package com.zrz.zblog.dao;

import com.zrz.zblog.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminUserMapper {

    AdminUser login(@Param("username") String username,@Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    Integer insert(AdminUser adminUser);

    int updateByPrimaryKeySelective(AdminUser adminUser);

    int updateByPrimaryKey(AdminUser adminUser);

}
