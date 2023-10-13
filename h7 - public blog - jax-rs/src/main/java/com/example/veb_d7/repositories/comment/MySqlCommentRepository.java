package com.example.veb_d7.repositories.comment;

import com.example.veb_d7.entities.Comment;
import com.example.veb_d7.entities.Post;
import com.example.veb_d7.repositories.MySqlAbstractRepository;

import javax.ws.rs.POST;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCommentRepository extends MySqlAbstractRepository implements CommentRepository {
    @Override
    public Comment addComment(Comment comment, Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("insert into comments (author, content, postID) values(?, ?, ?)", generatedColumns);
            preparedStatement.setString(1, comment.getAuthor());
            preparedStatement.setString(2, comment.getContent());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                comment.setCommentID(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return comment;
    }

    @Override
    public List<Comment> allComments(Post post) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from comments");

            while (resultSet.next()) {

                Comment comment = new Comment(resultSet.getString("author"), resultSet.getString("content"),
                        resultSet.getInt("postID"));

                synchronized (this) {
                    post.getComments().add(comment);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return post.getComments();
    }
}
