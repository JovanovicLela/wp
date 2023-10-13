package com.example.veb_d7.repositories.post;

import com.example.veb_d7.entities.Comment;
import com.example.veb_d7.entities.Post;

import java.util.List;

public interface PostRepository {
    Post addPost(Post post);
    Post findPost(Integer id);
    void deletePost(Integer id);
    List<Post> allPosts();

}
