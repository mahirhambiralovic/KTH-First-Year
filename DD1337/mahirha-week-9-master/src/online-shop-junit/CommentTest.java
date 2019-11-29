

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    Comment comment1;
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        comment1 = new Comment("Mahir", "The product sucks", 1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInit()
    {
        assertEquals("Mahir", comment1.getAuthor());
        assertEquals(1, comment1.getRating());
    }

    @Test
    public void testUpVoting()
    {
        // Test initial voteCount
        assertEquals(0, comment1.getVoteCount());
        // Test upvote
        comment1.upvote();
        comment1.upvote();
        assertEquals(2, comment1.getVoteCount());
    }

    @Test
    public void testDownVoting()
        {  
        // Test initial voteCount
        assertEquals(0, comment1.getVoteCount());
        // Test downvote
        comment1.downvote();
        comment1.downvote();
        assertEquals(-2, comment1.getVoteCount());
        }
}


