package com.example.httpCommunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@RestController
@CrossOrigin(origins = "*")
public class HttpCommunicationRestController {
    @Autowired
    private HttpCommService service;

    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @GetMapping("/get/username/{username}")
    public User getUserByName(@PathVariable String username){
        return service.getByUName(username);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return service.createNew(user);
    }

    @PostMapping("/username/change/{id}")
    public User updateUsername(@PathVariable Long id, @RequestParam String username){
        return service.updateUsername(id,username);
    }

    @PutMapping("/change/{id}")
    public User updateEmail(@PathVariable Long id, @RequestParam String email){
        return service.updateEmail(id,email);
    }


    @PostMapping("/delete/{id}")
//    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }

//    @PostMapping(path = "/user", produces = "application/xml")
//    public String greetingWithPathVariable() {
//        return "Hello! This a message from a simple application";
//    }
}