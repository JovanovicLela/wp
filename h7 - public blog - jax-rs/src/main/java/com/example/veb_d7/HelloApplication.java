package com.example.veb_d7;

import com.example.veb_d7.repositories.comment.CommentRepository;
import com.example.veb_d7.repositories.comment.MySqlCommentRepository;
import com.example.veb_d7.repositories.post.MySqlPostRepository;
import com.example.veb_d7.repositories.post.PostRepository;
import com.example.veb_d7.services.PostService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(MySqlPostRepository.class).to(PostRepository.class).in(Singleton.class);
                this.bind(MySqlCommentRepository.class).to(CommentRepository.class).in(Singleton.class);

                this.bindAsContract(PostService.class);
            }
        };
        this.register(binder);

        packages("com.example.veb_d7");
    }

}