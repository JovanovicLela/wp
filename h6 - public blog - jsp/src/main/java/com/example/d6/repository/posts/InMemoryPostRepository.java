package com.example.d6.repository.posts;

import com.example.d6.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPostRepository implements IPostRepository{

    private static final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    public static int idCounter = 1;

    @Override
    public List<Post> all() {
        return new ArrayList<Post>(posts.values());
    }

    @Override
    public Post find(int id) {
        return posts.get(id);
    }

    @Override
    public void insert(Post post) {
        posts.put(idCounter, post);
        idCounter++;

    }

}
