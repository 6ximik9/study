package bejeweled.server.webservice;


import bejeweled.entity.User;
import bejeweled.service.UserException;
import bejeweled.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserServiceRest {
     private final UserService userService;

    public UserServiceRest(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) throws UserException {
        userService.addUser(user);
    }

    @GetMapping("/{login}")
    public User getUser(@PathVariable String login){
       return userService.getUser(login);
    }

    @GetMapping("/all")
    public List<User> getAllUser() throws UserException{
            return userService.getAllUser();
    }
}
