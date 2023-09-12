package com.example.mavendemo01.mybatiscatalog.jpa;

import com.example.mavendemo01.mybatiscatalog.jpa.Comment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id =#{id}")
    public Comment findById(Integer id);


    //插入
    @Insert("INSERT INTO t_comment(content,author,a_id)"+"values (#{content},#{author},#{aId})")
    public int insertComment(Comment comment);

    //更新
    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    //删除
    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteComment(Integer id);

}
