/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import java.util.ArrayList;
import java.util.Date;
import museo.db.Visita;
import museo.util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class VisiteController {
    private Database db;
    private ArrayList <Visita> esposizioni;
    private ArrayList <Visita> visite_base;
    private Date dInizio=new Date(2016,01,01);
    private Date dFine=new Date(2016,12,31);
    
    public VisiteController(){
        db = new Database();
        visite_base=(ArrayList<Visita>) db.getVisite();
        esposizioni=(ArrayList<Visita>) db.getVisiteFromDate(dInizio, dFine);
    }
    
    @RequestMapping(value="/visite")
    public String visiteMuseo(ModelMap map){
        Date dInizio=new Date(2016,01,01);
        Date dFine=new Date(2016,12,31);
        map.put("visite",esposizioni); 
        map.put("visiteBase",visite_base);
        return "visite";
    }
    
    @RequestMapping(value={"","/homepage","/",})
    public String homeMuseo(ModelMap map){
        Date dInizio=new Date(2016,01,01);
        Date dFine=new Date(2016,12,31);
        map.put("visite",esposizioni); 
        map.put("visiteBase",visite_base);
        return "index";
    }
}
