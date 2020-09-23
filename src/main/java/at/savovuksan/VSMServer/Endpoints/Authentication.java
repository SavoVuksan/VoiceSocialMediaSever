package at.savovuksan.VSMServer.Endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.savovuksan.VSMServer.Models.User;

@RestController
@RequestMapping("/auth")
public class Authentication {
    
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return user;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        return user;
    }
}
