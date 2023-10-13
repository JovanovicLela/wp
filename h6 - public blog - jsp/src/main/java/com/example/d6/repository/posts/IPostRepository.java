package com.example.d6.repository.posts;

import com.example.d6.models.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> all();
    Post find(int id);
    void insert(Post post);


}
