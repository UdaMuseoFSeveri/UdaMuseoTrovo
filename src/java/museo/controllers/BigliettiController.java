/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import java.util.Date;
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
    public String getBigliettiPrenotati(ModelMap map, @RequestParam(value="timestamp", required=true)Date timestamp,@RequestParam(value="username", required=true)String username){
        map.put("biglietti", db.getBiglietti(timestamp,username));
        return "biglietti";
    }
}
