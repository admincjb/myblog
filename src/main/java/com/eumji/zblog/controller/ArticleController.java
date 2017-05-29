package com.eumji.zblog.controller;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.service.TagService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GeneratorFx on 2017-04-11.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;  //文章service

    @Resource
    private PartnerService partnerService; //友情链接service

    @Resource
    private CategoryService categoryService; //分类service

    @Resource
    private TagService tagService;  //标签service

    /**
     * 加载分页列表数据
     * @param pager
     * @param model
     * @return
     */
    @RequestMapping("/load")
    public String loadArticle(Pager<Article> pager, Model model){
        List<ArticleCustom> articleList = articleService.articleList(pager);
        System.out.println(articleList);
        model.addAttribute("articleList",articleList);
        return "blog/part/articleSummary";
    }

    /**
     * 加载文章
     * 包括总标签数
     * 总文章数量
     * 分类及每个分类文章数量
     * 友链集合
     *
     * @return
     */
    @RequestMapping("/details/{articleId}")
    public String loadArticle(@PathVariable Integer articleId, Model model){
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        //上一篇
        Article lastArticle = articleService.getLastArticle(articleId);
        //下一篇
        Article nextArticle = articleService.getNextArticle(articleId);
        //增加浏览量
        articleService.addArticleCount(articleId);
        //获取文章总数量
        int articleCount = articleService.getArticleCount();
        //标签总数量
        int tagCount = tagService.getTagCount();
        //当前文章的所有信息
        ArticleCustom articleCustom = articleService.getArticleCustomById(articleId);
        model.addAttribute("lastArticle",lastArticle);
        model.addAttribute("nextArticle",nextArticle);
        model.addAttribute("article",articleCustom);
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        return "blog/article";
    }

    /**
     * 全局搜索
     * @param keyword 关键字
     * @param model
     * @return
     */
    @RequestMapping("/content/search")
    public String search(String keyword,Model model){
        List<Article> articleList = articleService.getArticleListByKeywords(keyword);
        model.addAttribute("articleList",articleList);
        return "blog/part/search-info";
    }

}
