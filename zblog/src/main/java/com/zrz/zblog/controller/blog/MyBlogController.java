package com.zrz.zblog.controller.blog;


import com.alibaba.fastjson.JSON;
import com.zrz.zblog.controller.vo.BlogDetailVO;
import com.zrz.zblog.entity.BlogComment;
import com.zrz.zblog.entity.BlogLink;
import com.zrz.zblog.service.*;
import com.zrz.zblog.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author Rongze Zhao
 * @date 2019/7/30 14:43
 */
@Controller
public class MyBlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TagService tagService;
    @Resource
    private LinkService linkService;
    @Resource
    private CommentService commentService;
    @Resource
    private ConfigService configService;
    @Resource
    private CategoryService categoryService;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping({"/", "/index", "index.html"})
    public String index(Model model, HttpServletRequest request) {
        return this.page(model, request, 1);
    }

    /**
     * 首页 分页数据
     *
     * @return
     */
    @GetMapping({"/page/{pageNum}"})
    public String page(Model model, HttpServletRequest request, @PathVariable("pageNum") int pageNum) {
        PageResult blogPageResult = blogService.getBlogsForIndexPage(pageNum);
        if (blogPageResult == null) {
            return "error/error_404";
        }
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("configurations", configService.getAllConfigs());
        model.addAttribute("subUrl", "/");
        model.addAttribute("pageName", "Home");
        model.addAttribute("titleName", "Home");
        return "blog/index";
    }

    /**
     * Categories页面(包括分类数据和标签数据)
     * TODO
     *
     * @return
     */
    @GetMapping({"/categories"})
    public String categories(HttpServletRequest request) {
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.setAttribute("pageName", "分类页面");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/category";
    }

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/blog/{blogId}", "/article/{blogId}"})
    public String detail(Model model, HttpServletRequest request,
                         @PathVariable("blogId") Long blogId,
                         @RequestParam(value = "commentPage",
                                 required = false,
                                 defaultValue = "1") Integer commentPage) {

        BlogDetailVO blogDetailVO = blogService.getBlogDetail(blogId);

        if (blogDetailVO != null) {
            model.addAttribute("blogDetailVO", blogDetailVO);
            model.addAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
        }
        model.addAttribute("pageName", blogDetailVO.getBlogTitle());
        model.addAttribute("titleName", "Blog");
        model.addAttribute("configurations", configService.getAllConfigs());

        return "blog/blog-single";
    }

    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}"})
    public String tag(Model model, HttpServletRequest request, @PathVariable("tagName") String tagName) {
        return tag(model, request, tagName, 1);
    }

    /**
     * 标签列表页
     *
     * @return
     */
    @GetMapping({"/tag/{tagName}/{page}"})
    public String tag(Model model, HttpServletRequest request, @PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageByTag(tagName, page);
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("keyword", tagName);
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("configurations", configService.getAllConfigs());

        model.addAttribute("subUrl", "/tag/" + tagName);
        model.addAttribute("pageName", tagName);
        model.addAttribute("titleName", "Tag");

        return "blog/index";
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}"})
    public String category(Model model, HttpServletRequest request, @PathVariable("categoryName") String categoryName) {
        return category(model, request, categoryName, 1);
    }

    /**
     * 分类列表页
     *
     * @return
     */
    @GetMapping({"/category/{categoryName}/{page}"})
    public String category(Model model, HttpServletRequest request, @PathVariable("categoryName") String categoryName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageByCategory(categoryName, page);
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("keyword", categoryName);
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("configurations", configService.getAllConfigs());
        model.addAttribute("subUrl", categoryName);
        model.addAttribute("pageName", categoryName);
        model.addAttribute("titleName", "Category");
        return "blog/index";
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @PostMapping({"/search"})
    public String search(Model model, HttpServletRequest request, @RequestParam String keyword) {
        return search(model, request, keyword, 1);
    }

    /**
     * 搜索列表页
     *
     * @return
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public String search(Model model, HttpServletRequest request, @PathVariable("keyword") String keyword,
                         @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageBySearch(keyword, page);
        model.addAttribute("blogPageResult", blogPageResult);
        model.addAttribute("titleName", "Search");
        model.addAttribute("pageName", keyword);
        model.addAttribute("subUrl", "/search/" + keyword + "/1");
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        model.addAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        model.addAttribute("hotTags", tagService.getBlogTagCountForIndex());
        model.addAttribute("configurations", configService.getAllConfigs());
        return "blog/index";
    }


    /**
     * 友情链接页
     * TODO
     *
     * @return
     */
    @GetMapping({"/link"})
    public String link(HttpServletRequest request) {
        request.setAttribute("pageName", "友情链接");
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
        if (linkMap != null) {
            //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
            if (linkMap.containsKey((byte) 0)) {
                request.setAttribute("favoriteLinks", linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) 1)) {
                request.setAttribute("recommendLinks", linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) 2)) {
                request.setAttribute("personalLinks", linkMap.get((byte) 2));
            }
        }
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/link";
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long blogId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String email,
                          @RequestParam String commentBody) {
        if (StringUtils.isEmpty(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!verifyCode.equals(kaptchaCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (StringUtils.isEmpty(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == blogId || blogId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (StringUtils.isEmpty(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (StringUtils.isEmpty(email)) {
            return ResultGenerator.genFailResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResultGenerator.genFailResult("请输入正确的邮箱地址");
        }
        if (StringUtils.isEmpty(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        BlogComment comment = new BlogComment();
        comment.setBlogId(blogId);
        comment.setCommentator(MyBlogUtils.cleanString(commentator));
        comment.setEmail(email);
        comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }

    /**
     * 关于页面 以及其他配置了subUrl的文章页
     * TODO
     *
     * @return
     */
    @GetMapping({"/{subUrl}"})
    public String detail(HttpServletRequest request, @PathVariable("subUrl") String subUrl) {
        BlogDetailVO blogDetailVO = blogService.getBlogDetailBySubUrl(subUrl);
        if (blogDetailVO != null) {
            request.setAttribute("blogDetailVO", blogDetailVO);
            request.setAttribute("pageName", subUrl);
            request.setAttribute("configurations", configService.getAllConfigs());
            return "blog/detail";
        } else {
            return "error/error_400";
        }
    }



    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/test/{blogId}"})
    public String mkTestdetail(Model model,
                         @PathVariable("blogId") Long blogId,
                         @RequestParam(value = "commentPage",
                                 required = false,
                                 defaultValue = "1") Integer commentPage) {

        BlogDetailVO blogDetailVO = blogService.getBlogDetail(96L);

        if (blogDetailVO != null) {
            model.addAttribute("blogDetailVO", blogDetailVO);
            model.addAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
        }
        model.addAttribute("pageName", blogDetailVO.getBlogTitle());
        model.addAttribute("titleName", "Blog");
        model.addAttribute("configurations", configService.getAllConfigs());

        return "test";
    }

    @GetMapping({"/test/detile/{blogId}"})
    @ResponseBody
    public String mkTestdetailPost(
                               @PathVariable("blogId") Long blogId,
                               @RequestParam(value = "commentPage",
                                       required = false,
                                       defaultValue = "1") Integer commentPage) {

        BlogDetailVO blogDetailVO = blogService.getBlogDetail(96L);

        return JSON.toJSONString(blogDetailVO.getBlogContent() );
    }
}
