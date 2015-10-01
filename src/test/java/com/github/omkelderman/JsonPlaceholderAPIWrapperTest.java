package com.github.omkelderman;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Olle on 29-09-2015.
 */
public class JsonPlaceholderAPIWrapperTest {
    private JsonPlaceholderAPIWrapper api;

    @Before
    public void initialize() {
        api = new JsonPlaceholderAPIWrapper(new FakeResourceProvider());
    }

    @Test
    public void testPostsFromUserId1() throws IOException {
        List<String> postsFromUserId1 = api.getPostTitlesByUserId(1);

        assertEquals("userid1 - title1", postsFromUserId1.get(0));
        assertEquals("userid1 - title2", postsFromUserId1.get(1));
        assertEquals("userid1 - title3", postsFromUserId1.get(2));
        assertEquals("userid1 - title4", postsFromUserId1.get(3));
    }

    @Test
    public void testPostsFromUserId2() throws IOException {
        List<String> postsFromUserId2 = api.getPostTitlesByUserId(2);

        assertEquals("userid2 - title1", postsFromUserId2.get(0));
        assertEquals("userid2 - title2", postsFromUserId2.get(1));
        assertEquals("userid2 - title3", postsFromUserId2.get(2));
        assertEquals("userid2 - title4", postsFromUserId2.get(3));
    }
}
