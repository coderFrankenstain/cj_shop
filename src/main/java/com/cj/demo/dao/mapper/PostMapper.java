package com.cj.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.demo.dao.PostEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<PostEntity> {
    @Select("SELECT * FROM posts")
    List<PostEntity> selectAll();
}
