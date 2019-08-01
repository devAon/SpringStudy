package org.sopt.seminar2.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
    @GetMapping("")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/name/{name}")
    public String getName(@PathVariable(value = "name", required = false) final String name) {
        return name;
    }

}
