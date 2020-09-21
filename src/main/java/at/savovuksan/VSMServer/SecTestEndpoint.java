package at.savovuksan.VSMServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecTestEndpoint {

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome</h1> <a href=\"./user\" >User</a> <a href=\"./admin\" >Admin</a> <br> <a href=\"/logout\">Logout</a>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>Welcome User</h1> <a href=\"/\" >Unauthorized</a> <a href=\"./admin\" >Admin</a><br> <a href=\"/logout\">Logout</a>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Welcome Admin</h1> <a href=\"/\" >Unauthorized</a> <a href=\"./user\" >User</a><br> <a href=\"/logout\">Logout</a>"; 
    }
}
