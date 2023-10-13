package com.example.d6.servlets;

import com.example.d6.models.Post;
import com.example.d6.repository.posts.IPostRepository;
import com.example.d6.repository.posts.InMemoryPostRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewPostServlet", value = "/new-post")
public class NewPostServlet extends HttpServlet {

    private IPostRepository postRepository;

    @Override
    public void init() throws ServletException {
        postRepository = new InMemoryPostRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/new-post.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String content = request.getParameter("content");


           synchronized (postRepository) {
               if (!author.isEmpty() && !title.isEmpty() && !content.isEmpty()) {
               Post post = new Post(author, title, content, InMemoryPostRepository.idCounter, new ArrayList<>());
               this.postRepository.insert(post);
           }
        }
        response.sendRedirect(request.getContextPath() + "/posts");
    }
}
