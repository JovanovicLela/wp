package com.example.veb_d7.repositories.comment;

import com.example.veb_d7.entities.Comment;
import com.example.veb_d7.entities.Post;

import java.util.List;

public interface CommentRepository {
    Comment addComment(Comment comment, Integer id);
    List<Comment> allComments(Post post);


}
