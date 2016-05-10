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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"carrello", "user"})
public class BigliettiController {

    private Database db = new Database();

    @RequestMapping(value = "/carrello", method = RequestMethod.GET)
    public String getCarrello(ModelMap map, @ModelAttribute("carrello") List<Biglietto> carrello) {
      map.put("tikets", carrello);
        return "biglietti";

    }

    @RequestMapping(value = "/acquista", method = RequestMethod.GET)
    public String completaAcquisto(ModelMap map, @ModelAttribute("carrello") List<Biglietto> carrello, @ModelAttribute("user") Utente utente, SessionStatus status) {
        Timestamp dataPrenotazione = new Timestamp(System.currentTimeMillis());
        long millis = dataPrenotazione.getTime()-dataPrenotazione.getNanos()/1000000;
        dataPrenotazione = new Timestamp(millis);
        for (Biglietto b : carrello) {
            b.setDataPrenotazione(dataPrenotazione);
            db.salvaBiglietto(b);
        }
        map.addAttribute("carrello", new ArrayList<>());
        List<Biglietto> bi = db.getBiglietti(dataPrenotazione,utente);
        map.put("biglietti", bi);
        return "biglietti_comprati";

    }

    @RequestMapping(value = "/svuotaCarrello", method = RequestMethod.GET)
    public String svuotaCarrello(ModelMap map) {
        map.addAttribute("carrello", new ArrayList<>());
        return "redirect:/homepage";

    }
    @RequestMapping(value = "/removeBiglietto", method = RequestMethod.GET)
    public String rimuoviBiglietto(ModelMap map,@ModelAttribute("carrello") List<Biglietto> carrello, @RequestParam(value="id",required=true)int id) {
        carrello.remove(id);
        return "redirect:/carrello";

    }
}
