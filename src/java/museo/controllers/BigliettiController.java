/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;
import java.sql.Date;
import java.sql.Timestamp;
import museo.util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\magro3026
 */
@Controller
public class BigliettiController {
    private Database db = new Database();
    
    @RequestMapping(value="/bigliettiPrenotati",method=RequestMethod.GET)
    public String getBigliettiPrenotati(ModelMap map, @RequestParam(value="timetstamp", required=false)Date timetstamp,@RequestParam(value="tusername", required=false)String tusername){
        /**
        Date timestamp= new Date(2016,04,13,9,33,00);
        System.out.println(timestamp);
        String username = "MarioRossi";
        map.put("tikets", db.getBiglietti(timestamp,username));
        * */
        return "biglietti";
        
    }
}
