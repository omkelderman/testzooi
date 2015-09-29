package com.github.omkelderman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Olle on 29-09-2015.
 */
public class FakeJsonPlaceholderAPIWrapper extends JsonPlaceholderAPIWrapper {
    @Override
    protected BufferedReader getReaderForPath(String path) throws IOException {
        switch (path) {
            case "http://jsonplaceholder.typicode.com/posts?userId=1":
                return serveUserId1();
            case "http://jsonplaceholder.typicode.com/posts?userId=2":
                return serveUserId2();
            default:
                throw new RuntimeException("junit test incomplete");
        }
    }

    private BufferedReader serveUserId1() {
        return serveFile("postsFromUserId1.json");
    }

    private BufferedReader serveUserId2() {
        return serveFile("postsFromUserId2.json");
    }

    private BufferedReader serveFile(String filename) {
        InputStream inputStream = FakeJsonPlaceholderAPIWrapper.class.getClassLoader().getResourceAsStream(filename);
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
