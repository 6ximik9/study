package bejeweled.server.controller;


import bejeweled.entity.User;
import bejeweled.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


@Controller
@RequestMapping("/api")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {

    private static User loggedUser;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String requestBody) {
        JSONObject json = new JSONObject(requestBody);
        String login = json.getString("login");
        String password = json.getString("password");
        User user = userService.getUser(login);
        if(user!=null && user.getPass().equals(getMd5(password)))
        {
            System.out.println(2);
            loggedUser = user;
            JSONObject responseJson = new JSONObject();
            responseJson.put("message", "Login successful");
            return ResponseEntity.ok(responseJson.toString());

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login or password");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody String requestBody) {
        JSONObject json = new JSONObject(requestBody);
        String login = json.getString("login");
        String password = json.getString("password");

        User user = userService.getUser(login);
        if(user==null)
        {
            System.out.println(login);
            System.out.println(password);
            System.out.println(user);
            userService.addUser(new User(login, getMd5(password)));
            loggedUser = userService.getUser(login);
            JSONObject responseJson = new JSONObject();
            responseJson.put("message", "Register successful");
            return ResponseEntity.ok(responseJson.toString());

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The user exists");
    }


    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }




//    @RequestMapping("/login")
//    public String login(String login, String password) {
//        System.out.println(login + password);
////        User user = userService.getUser(login);
////        if(user!=null && user.getPass().equals(password))
////        {
////            System.out.println(2);
////            loggedUser = user;
////            return "redirect:/api/bejeweled";
////        }
//        return "redirect:/api/";
//    }

    @RequestMapping("/logout")
    public String logout() {
        loggedUser = null;
        return "redirect:/api/";
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public boolean isLogged() {
        return loggedUser != null;
    }



}
