package org.sopt.seminar3.lombok;

import org.sopt.seminar3.model.Post;

public class Main {
    public static void main(String... args) {
        Post post = new Post(1, "spring study", "second study");

        post.getContents();
    }
}
