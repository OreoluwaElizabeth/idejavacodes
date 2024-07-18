package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepoImpl implements PostRepository{
    private List<Post> posts = new ArrayList<>();

    @Override
    public Post save(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Post> findAll() {
        return List.of();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return posts.size();
    }
}
