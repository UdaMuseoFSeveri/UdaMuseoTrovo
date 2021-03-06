/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import java.util.ArrayList;
import java.sql.Date;
import museo.db.Biglietto;
import museo.db.Visita;
import museo.util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"carrello"})
public class VisiteController {
    private Database db;
    private ArrayList <Visita> esposizioni;
    private ArrayList <Visita> visite_base;
    private Date dInizio;
    private Date dFine;
    
    public VisiteController(){
        db = new Database();
        long in = 1451602800000L;
        dInizio = new Date(in);
        long fine = 1483138800000L;
        dFine = new Date(fine);
        visite_base=(ArrayList<Visita>) db.getVisite();
        esposizioni=(ArrayList<Visita>) db.getVisiteFromDate(dInizio, dFine);
    }
    
    @RequestMapping(value="/visite")
    public String visiteMuseo(ModelMap map){
        map.put("visite",esposizioni); 
        map.put("visiteBase",visite_base);
        return "visite";
    }
    
    @RequestMapping(value={"","/homepage","/",})
    public String homeMuseo(ModelMap map){
        if (!map.containsAttribute("carrello")) {
            map.addAttribute("carrello", new ArrayList<Biglietto>());
        }
        map.put("visite",esposizioni); 
        map.put("visiteBase",visite_base);
        return "index";
    }
}
