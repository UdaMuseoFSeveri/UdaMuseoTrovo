/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import museo.util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Controller
public class VisiteController {
    Database db;
    
    public VisiteController(){
        db = new Database();
        //db.getVisite();
    }
    
    @RequestMapping(value={"","/homepage","/"})
    public String visiteMuseo(ModelMap map){
        
        return "index";
    }
}
