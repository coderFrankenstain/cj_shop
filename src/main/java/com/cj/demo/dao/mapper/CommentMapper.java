package com.cj.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.demo.dao.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
    @Select("SELECT * FROM comments WHERE post_id = #{postId}")
    List<CommentEntity> findCommentsByPostId(@Param("postId") String postId);
}
