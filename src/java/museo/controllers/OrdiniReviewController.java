/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import museo.db.Utente;
import museo.util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author FSEVERI\trovo2987
 */
@Controller
@SessionAttributes({"user"})
public class OrdiniReviewController {
    private Database db;
    
    public OrdiniReviewController(){
        db = new Database();
    }
    
    @RequestMapping(value="/visualizzaOrdini")
    public String visualizzaOrdini(ModelMap map,@ModelAttribute("user")Utente nomeUtente){
        map.put("visualizzaOrdini",db.getBigliettiForReview(nomeUtente.getNomeUtente()));
        return "visualizzaOrdini";
    }
}