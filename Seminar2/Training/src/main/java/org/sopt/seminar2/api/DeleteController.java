package org.sopt.seminar2.api;

import org.sopt.seminar2.model.Toy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delete")
public class DeleteController {
    @DeleteMapping("")
    public String deleteToy(@RequestBody final Toy toy) {
        return toy.toString();
    }
}
