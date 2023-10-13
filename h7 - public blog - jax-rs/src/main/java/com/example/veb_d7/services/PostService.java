package com.example.veb_d7.services;

import com.example.veb_d7.entities.Comment;
import com.example.veb_d7.entities.Post;
import com.example.veb_d7.repositories.comment.CommentRepository;
import com.example.veb_d7.repositories.post.PostRepository;

import javax.inject.Inject;
import java.util.List;

public class PostService {

    public PostService() {
        System.out.println(this);
    }

    @Inject
    private PostRepository postRepository;

    @Inject
    private CommentRepository commentRepository;

    public Post addPost(Post post) {
        return this.postRepository.addPost(post);
    }

    public Post findPost(Integer id) {
        return this.postRepository.findPost(id);
    }

    public void deletePost(Integer id) {
         this.postRepository.deletePost(id);
    }

    public Comment addComment(Comment comment, Integer id){
        return this.commentRepository.addComment(comment, id);
    }

    public List<Comment> allComments(Post post) {
        return this.commentRepository.allComments(post);
    }

    public List<Post> allPosts() {
        return this.postRepository.allPosts();
    }
}
