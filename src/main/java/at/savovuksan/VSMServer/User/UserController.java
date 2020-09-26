package at.savovuksan.VSMServer.User;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepo.findAll();
        ResponseEntity<List<User>> re = new ResponseEntity<List<User>>(users,(users.size() > 0? HttpStatus.OK: HttpStatus.NO_CONTENT));
        return re;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") int id) {
        Optional<User> opt;
        opt = userRepo.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<User>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody() User u){
        // Does User with email already exist?
        Optional<User> u1 = userRepo.findByEmail(u.getEmail());
        if(u1.isEmpty()){
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        User nu = userRepo.save(u);
        nu.setPassword("");
        return new ResponseEntity<User>(nu,HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
