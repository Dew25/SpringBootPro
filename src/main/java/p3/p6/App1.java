/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.p6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Melnikov
 */
@RestController
@SpringBootApplication
public class App1 {
    @RequestMapping("/hello")
    public String helloFunction2(String firstname){
        return "Hello "+firstname+"!";
    }
    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }
    
}
