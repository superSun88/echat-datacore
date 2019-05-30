package sun.echat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCoreController {
   
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(){
        return "hello";
    }
}