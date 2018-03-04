/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3.p6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    public String helloFunction2(String firstname) {
        return "Hello " + firstname + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App1.class, args);
    }

    String readUrl(String address) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(address).openStream()));
            return br.readLine();
        } catch (Exception e) {
            return "-1";
        }
    }
    @RequestMapping("/exrcises")
    public String answers(String count) {
        try {
            String jsonStr = readUrl("http://johiv6.herokuapp.com/numberList?count="+Integer.parseInt(count));
            JSONParser jp = new JSONParser();
            JSONArray ja = (JSONArray) jp.parse(jsonStr);
            String  s = "<html><body>";
            for (Object a : ja) {
                JSONArray a2 = (JSONArray) a;
               s+=a2.get(0)+" * "+a2.get(1)+"<br>"; 
            }
            s+="</body></html>";
            return s;
            
        } catch (ParseException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }
    
}
