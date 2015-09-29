package com.github.omkelderman;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        JsonPlaceholderAPIWrapper api = new JsonPlaceholderAPIWrapper();

        try {
            for (String title : api.getPostTitlesByUserId(1)) {
                System.out.println(title);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
