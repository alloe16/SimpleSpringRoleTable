package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller

public class Controller {
    @Autowired private Test test;
    @GetMapping("")
    public String test(Model model){
        model.addAttribute("new_User",new UserEntity());
        return "index";
    }
    @GetMapping("/register.html")
    public String test2(Model model){
        model.addAttribute("new_User",new UserEntity());
        return "register";
    }
    @GetMapping("/welcome.html")
    public String test3(){
        return "welcome";
    }
    @GetMapping("/table.html")
    public String table(Model model){
        return "table";
    }
    @PostMapping("/check")
    public String check1(Model model, UserEntity user){
        List<UserEntity> users = test.Out();
        if(user.getName().equals("root") && user.getPassword().equals("root")) {
            model.addAttribute("AdminList", users);
            return "table";
        }
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getName().equals(user.getName()) && (users.get(i).getPassword().equals(user.getPassword()))) {
                model.addAttribute("UserList", users.get(i));
                return "welcome";
            }
            }
        return "index";
        }

    @PostMapping("/add")
    public String add1(UserEntity user){
        List<UserEntity> users = test.Out();
        user.setIdUser(users.size()+1);
        for(int i = 0; i<users.size();i++){
            if (users.get(i).getName().equals(user.getName()) || (users.get(i).getPassword().equals(user.getPassword()))||(users.get(i).getEmail().equals(user.getEmail()))) {
                return "register";
            }
        }
        test.add(user);
        return "index";

    }

}
