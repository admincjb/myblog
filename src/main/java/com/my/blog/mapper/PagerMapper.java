package com.my.blog.mapper;

import com.my.blog.vo.Pager;
import org.apache.ibatis.annotations.Mapper;

/**
 * 分页的mapper
 * @author EumJi
 * @package com.my.blog.mapper
 * @name PagerMapper.java
 * @date 2017/4/13
 * @time 9:07
 */
@Mapper
public interface PagerMapper {
    /**
     * 找到目标分类下的分页条件
     * @param categoryId
     * @return
     */
    int loadCategoryPager(Integer categoryId);

    /**
     * 通过tagId获取文章总数量
     * @param tagId
     * @return
     */
    int loadTagPager(Integer tagId);

    /**
     * 初始化时间归档的分页信息
     * @param createTime
     * @return
     */
    int loadArchivePager(String createTime);
}
