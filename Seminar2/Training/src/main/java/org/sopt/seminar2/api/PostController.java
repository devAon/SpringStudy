package org.sopt.seminar2.api;

import org.sopt.seminar2.model.Toy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post")
public class PostController {
    @PostMapping("")
    public String postToy(@RequestBody final Toy toy) {
        return toy.toString();
    }
}


/*method : post
url : 127.0.0.1:8080/post
req.body :
{
"id" : 1234,
"name" : "pupuppy"
}
result :
ToyId : 1234, ToyName : pupuppy*/


