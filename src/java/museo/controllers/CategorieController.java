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
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author FSEVERI\magro3026
 */

@Controller
public class CategorieController {
    Database db = new Database();
    
    @RequestMapping(value="/categorie",method=RequestMethod.GET)
    public String getCategorie(ModelMap map){
        map.put("categorie", db.getCategorie());
        return "categorie";
    }
}
