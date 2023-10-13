package com.example.d6.servlets;

import com.example.d6.models.Comment;
import com.example.d6.models.Post;
import com.example.d6.repository.posts.IPostRepository;
import com.example.d6.repository.posts.InMemoryPostRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SinglePostServlet", value = "/posts/*")
public class SinglePostServlet extends HttpServlet {

    private IPostRepository postRepository;

    @Override
    public void init() throws ServletException {
        postRepository = new InMemoryPostRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getPathInfo());
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        Post post = this.postRepository.find(id);
        request.setAttribute("post", post);
        request.getRequestDispatcher("/single-post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("name");
        String comment = request.getParameter("comment");

        int id = Integer.parseInt(request.getPathInfo().substring(1));
        Post post = this.postRepository.find(id);

        List<Comment> comments = post.getComments();
        comments.add( new Comment(author, comment));
        post.setComments(comments);

        response.sendRedirect( "/posts/" + id);
    }
}
