package com.my.blog.service.impl;

import com.my.blog.mapper.ArticleMapper;
import com.my.blog.mapper.PagerMapper;
import com.my.blog.service.PagerService;
import com.my.blog.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Do
 * @package com.my.blog.service.impl
 * @name PagerServiceImpl
 * @date 2017/4/11
 * @time 21:46
 */
@Service
public class PagerServiceImpl implements PagerService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private PagerMapper pagerMapper;
    @Override
    public void initPage(Pager pager) {
        int count = articleMapper.getArticleCount();
        pager.setTotalCount(count);
    }

    @Override
    public void loadCategoryPager(Pager pager,Integer categoryId) {
        int count = pagerMapper.loadCategoryPager(categoryId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadTagPager(Pager pager, Integer tagId) {
        int count = pagerMapper.loadTagPager(tagId);
        pager.setTotalCount(count);
    }

    @Override
    public void loadArchivePager(Pager pager, String createTime) {
        int count = pagerMapper.loadArchivePager(createTime);
        pager.setTotalCount(count);
    }
}
