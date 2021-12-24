package com.example.httpCommunication;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class HttpCommRepository {
    List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(Long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User getByUName(String username){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    }

    public User updateUsername(Long id, String username){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                User changed=users.get(i);
                changed.setUsername(username);
                return changed;
            }
        }
        return null;
    }

    public User updateEmail(Long id, String email){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                User user=users.get(i);
                user.setEmail(email);
                return user;
            }
        }
        return null;
    }

    public User createUser(User user){
        long range = 1000;
        Random r = new Random();
        long rand = (long)(r.nextDouble()*range);
        user.setId(rand);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                System.out.println("Error: User with such id already exists!");
                return null;
            }
        }
        User newUser=new User(rand,user.getUsername(), user.getFirstName(),user.getLastName(),user.getEmail());
        users.add(newUser);
        return newUser;
    }

    public String deleteUser(Long id){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(users.get(i));
                return ("The user with id "+id+" was successfully deleted");
            }
        }
        return ("No such user exists.");
    }


}
