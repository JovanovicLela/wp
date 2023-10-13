package com.example.d6.servlets;

import com.example.d6.repository.posts.IPostRepository;
import com.example.d6.repository.posts.InMemoryPostRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PostsServlet", value = {"/", "/posts"})
public class PostsServlet extends HttpServlet {

    private IPostRepository postRepository;

    @Override
    public void init() throws ServletException {
        this.postRepository = new InMemoryPostRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("posts", this.postRepository.all());
        request.getRequestDispatcher("/posts.jsp").forward(request, response);
    }

}
