package data.repositories;

import data.models.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);
    Post findById(int id);
    void deleteById(int id);
    List<Post> findAll();
    void deleteAll();
    long count();
}
