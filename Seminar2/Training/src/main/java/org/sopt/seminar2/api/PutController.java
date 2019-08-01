package org.sopt.seminar2.api;

import org.sopt.seminar2.model.Toy;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("put")
public class PutController {
    @PutMapping("")
    public String putToy(@RequestBody final Toy toy) {
        return toy.toString();
    }
}

/*method : put
url : 127.0.0.1:8080/put
req.body :
{
	"id" : 4887,
    "name" : "pooopoooSSong"
}
result :
ToyId : 4887, ToyName : pooopoooSSong
*/