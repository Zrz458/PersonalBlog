package com.zrz.zblog;

import com.zrz.zblog.dao.AdminUserMapper;
import com.zrz.zblog.dao.BlogCategoryMapper;
import com.zrz.zblog.entity.AdminUser;
import com.zrz.zblog.entity.BlogCategory;
import com.zrz.zblog.entity.BlogLink;
import com.zrz.zblog.entity.BlogTagCount;
import com.zrz.zblog.service.AdminUserService;
import com.zrz.zblog.service.CategoryService;
import com.zrz.zblog.service.LinkService;
import com.zrz.zblog.service.TagService;
import com.zrz.zblog.util.PageQueryUtil;
import com.zrz.zblog.util.PageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@MapperScan("com.zrz.zblog.dao")
@SpringBootTest
public class ZblogApplicationTests {

//    @Resource
//    AdminUserMapper adminUserMapper;
//
//    @Resource
//    BlogCategoryMapper categoryMapper;
//
//    @Autowired
//    AdminUserService adminUserService;
//
//    @Autowired
//    CategoryService categoryService;
//
//    @Test
//    public void adminUserMapperTest() {
//        // insert AdminUser
////        AdminUser adminUser = new AdminUser();
////        adminUser.setLoginUserName("admin");
////        adminUser.setLoginPassword(MD5Util.MD5Encode("123456","UTF-8"));
////        adminUser.setNickName("赵荣泽");
////        adminUser.setLocked((byte) 0);
////        Integer insert = adminUserMapper.insert(adminUser);
////        System.out.println(insert);
//
//        // selectByPrimaryKey
////        AdminUser adminUser1 = adminUserMapper.selectByPrimaryKey(1);
////        System.out.println(adminUser1);
//
//        AdminUser adminUser1 = adminUserMapper.selectByPrimaryKey(1);
//        adminUser1.setNickName("赵荣泽");
//        adminUserMapper.updateByPrimaryKey(adminUser1);
//    }
//
//    @Test
//    public void adminUserServiceTest() {
//        AdminUser admin = adminUserService.login("admin", "123456");
//        System.out.println(admin);
//    }
//
//
//    @Test
//    public void BlogCategoryMapperTest() {
////        BlogCategory category = new BlogCategory("Java", 1, (byte) 0, new Date());
////        BlogCategory category1 = new BlogCategory("C", 2, (byte) 0, new Date());
////        BlogCategory category2 = new BlogCategory("Python", 3, (byte) 0, new Date());
////        BlogCategory category3 = new BlogCategory("PHP", 4, (byte) 0, new Date());
////        categoryMapper.insert(category);
////        categoryMapper.insert(category1);
////        categoryMapper.insert(category2);
////        categoryMapper.insert(category3);
//
//        Integer[] ints = new Integer[]{1, 2, 3};
//        List<Integer> list = Arrays.asList(ints);
//        List<BlogCategory> blogCategories = categoryMapper.selectByCategoryIds(list);
//
//        for (BlogCategory blogCategory : blogCategories
//        ) {
//            System.out.println(blogCategory);
//        }
//
//        System.out.println("======================");
//
//        BlogCategory blogCategory = categoryMapper.selectByPrimaryKey(1);
//        blogCategory.setCategoryName("GO");
//        int i = categoryMapper.updateByPrimaryKeySelective(blogCategory);
//        System.out.println(i);
//
//        System.out.println("======================");
//        BlogCategory blogCategory1 = categoryMapper.selectByCategoryName("Python");
//        System.out.println(blogCategory1);
//
//    }
//
//    @Test
//    public void CategoryServiceImplTest() {
//        System.out.println("=========saveCategory=============");
////        categoryService.saveCategory("Java");
//        System.out.println("==========updateCategory============");
////        categoryService.updateCategory(1, "Java");
//        System.out.println("===========deleteBatch===========");
////        Boolean aBoolean = categoryService.deleteBatch(new Integer[]{1, 2, 3});
////        System.out.println(aBoolean);
//        System.out.println("=========getAllCategories=============");
//        List<BlogCategory> allCategories = categoryService.getAllCategories();
//        for (BlogCategory category:allCategories
//             ) {
//            System.out.println(category);
//        }
//        System.out.println("==========getTotalCategories============");
//        int totalCategories = categoryService.getTotalCategories();
//        System.out.println(totalCategories);
//        System.out.println("==========getBlogCategoryPage============");
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("page",2);
//        map.put("limit",2);
//        PageQueryUtil queryUtil = new PageQueryUtil(map);
//        PageResult blogCategoryPage = categoryService.getBlogCategoryPage(queryUtil);
//        System.out.println(blogCategoryPage);
//    }
//
//    @Autowired
//    TagService tagService;
//
//    @Test
//    public void TagServiceImplTest(){
//        System.out.println("==========saveTag============");
//        Boolean tag2 = tagService.saveTag("tag2");
//        Boolean tag3 = tagService.saveTag("tag3");
//        Boolean tag4 = tagService.saveTag("tag4");
//        Boolean tag5 = tagService.saveTag("tag5");
//        System.out.println("==========getTotalTags============");
//        int totalTags = tagService.getTotalTags();
//        System.out.println(totalTags);
//        System.out.println("==========getBlogTagCountForIndex============");
//        List<BlogTagCount> index = tagService.getBlogTagCountForIndex();
//        System.out.println("==========deleteBatch============");
////        tagService.deleteBatch(new Integer[]{1});
//        System.out.println("==========getBlogTagPage============");
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("page",2);
//        map.put("limit",2);
//        PageQueryUtil queryUtil = new PageQueryUtil(map);
//        PageResult pageResult = tagService.getBlogTagPage(queryUtil);
//        System.out.println(pageResult);
//    }
//
//    @Autowired
//    LinkService linkService;
//
//    @Test
//    public void LinkServiceImplTest(){
//        System.out.println("==========saveLink============");
////        BlogLink blogLink = new BlogLink();
////        blogLink.setLinkType((byte) 1);
////        blogLink.setLinkName("name2");
////        blogLink.setLinkUrl("www.baidu.com");
////        blogLink.setLinkDescription("baidu");
////        blogLink.setLinkRank(1);
////        blogLink.setIsDeleted((byte) 0);
////        linkService.saveLink(blogLink);
//        System.out.println("==========selectById============");
////        BlogLink blogLink = linkService.selectById(1);
////        System.out.println(blogLink);
//        System.out.println("==========updateLink============");
//        BlogLink blogLink = new BlogLink();
//        blogLink.setLinkId(1);
//        blogLink.setLinkType((byte) 1);
//        blogLink.setLinkName("name2");
//        blogLink.setLinkUrl("www.souhu.com");
//        blogLink.setLinkDescription("baidu");
//        blogLink.setLinkRank(1);
//        blogLink.setIsDeleted((byte) 0);
//        Boolean aBoolean = linkService.updateLink(blogLink);
//        System.out.println(aBoolean);
//        System.out.println("==========getTotalLinks============");
//        int totalLinks = linkService.getTotalLinks();
//        System.out.println(totalLinks);
//        System.out.println("==========getLinksForLinkPage============");
//        Map<Byte, List<BlogLink>> linksForLinkPage =
//                linkService.getLinksForLinkPage();
//        System.out.println(linksForLinkPage);
//    }
//
    @Test
    public void test(){
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //从前端或者自己模拟一个日期格式，转为String即可
//        String dateStr = format.format(date);
//
//        System.out.println(dateStr);
    }
}
