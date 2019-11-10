package com.zrz.zblog.service;

import com.zrz.zblog.entity.AdminUser;

public interface AdminUserService {

    /**
     * 登录
     *
     * @param
     * @author Rongze Zhao
     * @date 2019/7/29 13:21
     */
    AdminUser login(String userName, String password);

    /**
     * 获取用户信息
     *
     * @param
     * @author Rongze Zhao
     * @date 2019/7/29 13:22
     */
    AdminUser getUserDetailById(Integer loginUserId);

    /**
     * 修改当前登录用户的密码
     *
     * @param
     * @author Rongze Zhao
     * @date 2019/7/29 13:22
     */
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息
     *
     * @param
     * @author Rongze Zhao
     * @date 2019/7/29 13:23
     */
    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);

}
