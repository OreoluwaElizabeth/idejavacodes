import data.models.Post;
import data.repositories.PostRepoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostRepoTest {

    @Test
    public void testSave() {
        PostRepoImpl repo = new PostRepoImpl();
        Post post = new Post();
        post.setId(123);
        repo.save(post);
        assertEquals(1, repo.count());
    }

    @Test
    public void testTwoImplSave() {
        PostRepoImpl repo = new PostRepoImpl();
        Post post1 = new Post();
        Post post2 = new Post();
        post1.setId(234);
        post2.setId(456);
        repo.save(post1);
        repo.save(post2);
        assertEquals(2, repo.count());
    }
}
