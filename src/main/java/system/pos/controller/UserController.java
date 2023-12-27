package system.pos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import system.pos.entity.User;
import system.pos.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users/{id}")
    public Optional<User> getUsers(@PathVariable Long id){
        return userService.getById(id);
    }
}
