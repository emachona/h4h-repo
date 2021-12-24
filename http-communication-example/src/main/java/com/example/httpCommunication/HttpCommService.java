package com.example.httpCommunication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HttpCommService {
    @Autowired
    private HttpCommRepository repository;

    public List<User> getUsers(){
        return repository.getUsers();
    }

    public User getUserById(Long id){
        return repository.getUserById(id);
    }

    public User getByUName(String username){
        return repository.getByUName(username);
    }

    public User updateUsername(Long id, String username){return repository.updateUsername(id,username);}

    public User updateEmail(Long id, String email){
        return repository.updateEmail(id,email);
    }

    public User createNew(User user){
        return repository.createUser(user);
    }

    public String deleteUser(Long id){
        return repository.deleteUser(id);
    }
}
