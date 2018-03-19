package com.my.blog.controller;

import com.my.blog.service.CategoryService;
import com.my.blog.service.PagerService;
import com.my.blog.service.TagService;
import com.my.blog.vo.ArticleCustom;
import com.my.blog.vo.Pager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 页面管理的controller
 * @author EumJi
 * @package com.my.blog.controller.admin
 * @name PagerController
 * @date 2017/4/11
 * @time 21:44
 */
@RestController
public class PagerController {

    @Resource
    private PagerService pagerService;  //分页的service
    @Resource
    private TagService tagService;  //标签的service

    /**
     * 初始化文章分页信息
     * @return
     */
    @RequestMapping("/pager/articles/load")
    public Pager loadArticlePager(Pager pager){
        pagerService.initPage(pager);
        return pager;
    }

    /**
     * 初始化当前分类id的文章分页信息
     * @param pager 分页对象
     * @param categoryId 分类id
     * @return
     */
    @RequestMapping("/pager/categories/{categoryId}")
    public Pager loadCategoryPager(Pager pager,@PathVariable Integer categoryId){
        pagerService.loadCategoryPager(pager,categoryId);
        return pager;
    }

    /**
     *初始化当前标签的文章分页信息
     * @param pager 分页对象
     * @param tagId 标签
     * @return
     */
    @RequestMapping("/pager/tags/{tagId}")
    public Pager initPage(Pager pager,@PathVariable Integer tagId){
        tagService.ArticleTagPage(pager,tagId);
        return pager;
    }

    @GetMapping("/pager/archive/{createTime}")
    public Pager loadArchivePager(Pager pager,@PathVariable String createTime){
        pagerService.loadArchivePager(pager,createTime);
        return pager;
    }

}