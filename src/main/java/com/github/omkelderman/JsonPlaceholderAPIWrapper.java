package com.github.omkelderman;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olle on 29-09-2015.
 */
public class JsonPlaceholderAPIWrapper {
    private static final String ENDPOINT = "http://jsonplaceholder.typicode.com/";

    public List<String> getPostTitlesByUserId(int userId) throws IOException {
        String url = ENDPOINT + "posts?userId=" + userId;
        JsonElement root = getJsonForPath(url);
        JsonArray posts = root.getAsJsonArray();
        List<String> titles = new ArrayList<>(posts.size());
        for (JsonElement post : posts) {
            String title = post.getAsJsonObject().get("title").getAsString();
            titles.add(title);
        }
        return titles;
    }

    private JsonElement getJsonForPath(String path) throws IOException {
        BufferedReader reader = getReaderForPath(path);
        JsonElement root = new JsonParser().parse(reader);
        reader.close(); //TODO close stream properly when exception thrown
        return root;
    }

    protected BufferedReader getReaderForPath(String path) throws IOException {
        URL url = new URL(path);
        return new BufferedReader(new InputStreamReader(url.openStream()));
    }
}
