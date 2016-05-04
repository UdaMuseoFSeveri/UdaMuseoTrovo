/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import museo.db.*;
import museo.util.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author FSEVERI\magro3026
 */
@Controller
@SessionAttributes({"carrello", "user"})
public class BigliettiController {

    private Database db = new Database();

    @RequestMapping(value = "/carrello", method = RequestMethod.GET)
    public String getBigliettiPrenotati(ModelMap map, @ModelAttribute("carrello") List<Biglietto> carrello) {
        map.put("tikets", carrello);
        return "biglietti";

    }

    @RequestMapping(value = "/acquista", method = RequestMethod.GET)
    public String completaAcquisto(ModelMap map, @ModelAttribute("carrello") List<Biglietto> carrello, @ModelAttribute("user") Utente utente, SessionStatus status) {
        /*if (!map.containsAttribute("carrello")) {
            map.addAttribute("carrello", new ArrayList<Biglietto>());
        }*/
        Timestamp dataPrenotazione = new Timestamp(System.currentTimeMillis());
        for (Biglietto b : carrello) {
            b.setDataPrenotazione(dataPrenotazione);
            db.salvaBiglietto(b);
        }
        //status.setComplete();
        map.addAttribute("carrello", new ArrayList<>());
        System.out.println(utente.getNomeUtente());
        List<Biglietto> bi = db.getBiglietti(dataPrenotazione, utente.getNomeUtente());
        for(Biglietto b: bi){
            System.out.println(b);
        }
        map.put("biglietti", null);
        return "biglietti_comprati";

    }

    @RequestMapping(value = "/svuotaCarrello", method = RequestMethod.GET)
    public String svuotaCarrello(SessionStatus status) {
        status.setComplete();
        return "redirect:/homepage";

    }
}
