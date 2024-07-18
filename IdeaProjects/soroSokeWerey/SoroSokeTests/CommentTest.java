import data.models.Comments;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentTest {

    @Test
    public void testCommentId() {
        Comments comment = new Comments();
        comment.setId(1);
        assertEquals(1, comment.getId());
    }

    @Test
    public void testCommentUserId() {
        Comments comment = new Comments();
        comment.setUserId(234);
        assertEquals(234, comment.getUserId());
    }

    @Test
    public void testCommentContent(){
        Comments comment = new Comments();
        comment.setContent("I support");
        assertEquals("I support",comment.getContent());
    }

    @Test
    public void testCommentPostId() {
        Comments comment = new Comments();
        comment.setPostId("123");
        assertEquals("123",comment.getPostId());
    }

    @Test
    public void testCommentTimeCreated() {
        Comments comment = new Comments();
        comment.setCreatedAt(LocalDateTime.now());
        assertEquals(LocalDateTime.now(),comment.getCreatedAt());
    }
}
