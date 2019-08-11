package org.sopt.seminar3.api;

/*
POST /board 게시글 등록
GET /board 모든 게시글 조회
GET/ board/{idx} 해당 게시글만 조회
*/

import org.sopt.seminar3.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class PostController {

    final private static List<Post> postList = new LinkedList<>();

    @GetMapping("/board")
    public String getAllPost() {
        return postList.toString();
    }

    @GetMapping("/board/{idx}")
    public String getIdxPost(@PathVariable(value = "idx") final int idx) {
        for (Post list : postList) {
            if (list.getIdx() == idx) {
                return list.toString();
            }
        }
        return "존재하지 않는 게시글입니다.";
    }

    @PostMapping("/board")
    public String postPost(@RequestBody Post post) {
        postList.add(post);
        return post.toString() + "게시글이 저장됐습니다.";
    }
}
