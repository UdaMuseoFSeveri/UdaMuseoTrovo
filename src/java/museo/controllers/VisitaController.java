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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Controller
public class VisitaController {
    private Database db;
    
    public VisitaController(){
        db = new Database();
    }
    
    @RequestMapping(value="/visita")
    public String visitaMuseo(ModelMap map,@RequestParam(value="codice", required=true)int id){
        map.put("visita",db.getEventoById(id));
        return "visita";
    }
}
