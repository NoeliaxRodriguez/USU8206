package com.grupo06.usu8206.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.grupo06.usu8206.repos.UserDAO;
import com.grupo06.usu8206.mysql.entities.User;

import java.util.List;

@Controller
public class UserController {

    static final String basePath = "/restful";

    // DAO (Data Access Object) / CRUD
    @Autowired
    UserDAO uDao;

    // GET - Extraer info de bbdd (listar todos los usuarios)
    @RequestMapping(value = basePath + "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers() {
        List<User> userList = null;
        try {
            userList = uDao.findAll();

        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }

    // GET (by id) - Extraer info de bbdd (listar un usuario por id)
    @RequestMapping(value = basePath + "/users/{user_name}", method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable String user_name) {
        User fromDbUser = null;
        try {
            fromDbUser = uDao.findById(user_name).orElse(null);

        } catch (Exception e) {
            System.out.println(e);
        }
        return fromDbUser;
    }

    //POST
    @RequestMapping(value = basePath+"/req", method = RequestMethod.POST)
    public @ResponseBody
    String respondPUT() {
        return "<h1> Ejemplo POST </h1> ";
    }

    //PUT
    @RequestMapping(value = basePath+"/req", method = RequestMethod.PUT)
    public @ResponseBody
    String respondPOST() {
        return "<h1> Ejemplo PUT </h1> ";
    }


    //DELETE
    @RequestMapping(value = basePath+"/req", method = RequestMethod.DELETE)
    public @ResponseBody
    String respondDELETE() {
        return "<h1> Ejemplo DELETE </h1> ";
    }

}
