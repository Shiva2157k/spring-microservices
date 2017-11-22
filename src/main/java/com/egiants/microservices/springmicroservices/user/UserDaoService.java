package com.egiants.microservices.springmicroservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 6;

    static {
        users.add(new User(1,"Adam", new Date()));
        users.add(new User(2,"Jack", new Date()));
        users.add(new User(3,"Kelly", new Date()));
        users.add(new User(4,"VJ", new Date()));
        users.add(new User(5,"Danny", new Date()));
        users.add(new User(6,"Lisa", new Date()));
    }

     public List<User> findAll(){
        return users;
     }
     public User save(User user){
         if(user.getId() == null){
             user.setId(++usersCount);
         }
         users.add(user);
         return user;
     }

     public User findOne(int id){

         for(User user:users){
             if(user.getId() == id){
                 return user;
             }
         }
         return null;
     }

     public User deleteById(int id) {
         Iterator<User> iterator = users.iterator();
         while(iterator.hasNext()) {
             User user = iterator.next();
             if (user.getId() == id) {
                 iterator.remove();
                 return user;
             }
         }
         return null;
     }

}
