import data.models.Post;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {

    @Test
    public void testId(){
       Post post = new Post();
       post.setId(1);
       assertEquals(1, post.getId());
    }

    @Test
    public void testTitle() {
        Post post = new Post();
        post.setTitle("Soro Soke");
        assertEquals("Soro Soke",post.getTitle());
    }

    @Test
    public void testContent() {
        Post post = new Post();
        post.setContent("Ikoyi");
        assertEquals("Ikoyi", post.getContent());
    }

    @Test
    public void testUpdatedTime() {
        Post post = new Post();
        post.setUpdatedAt(LocalDateTime.now());
        assertEquals(LocalDateTime.now(),post.getUpdatedAt());
    }

}
