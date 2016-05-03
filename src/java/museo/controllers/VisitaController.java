/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museo.controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
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

/**
 *
 * @author FSEVERI\trovo2987
 */
@Controller
@SessionAttributes({"carrello"})
public class VisitaController {

  private Database db;

  public VisitaController() {
    db = new Database();
  }

  @RequestMapping(value = "/visita")
  public String visitaMuseo(ModelMap map, @RequestParam(value = "codice", required = true) int id) {
    //verifico se l'arry di sessione esiste, se non esiste lo crea 
    if (!map.containsAttribute("carrello")) {
      map.addAttribute("carrello", new ArrayList<Biglietto>());
    }
    Visita v = db.getEventoById(id);
    if(v.getTipo() != 'E')  {
        Date datafine = db.dataFine(new Date(System.currentTimeMillis()));
        map.put("dataFine",datafine);
    }
    map.put("visita", v);
    map.put("categorie", db.getCategorie());
    map.put("servizi", db.getServizi());
    map.put("num_biglietti",db.getNBigliettiEspozioni(id));
    map.put("soldi_biglietti", db.getRicavoEsposizioni(id));
    
    return "visita";
  }

  @RequestMapping(value = "/addBiglietto", method = RequestMethod.GET)
  public String aggiungiBigletto(ModelMap map, @RequestParam(value = "dataValidita", required = true) Date dataValidita, @RequestParam(value = "codiceVisita") int visita, @RequestParam(value = "servizi", required = false) List<Integer> servizi,/*@ModelAttribute List<Servizio> servizi, */
          @RequestParam(value = "nomeUtente", required = true) String nomeUtente, @RequestParam(value = "categoria", required = true) int codiceCategoria, @ModelAttribute("carrello") List<Biglietto> carrello) {
    Collection<Servizio> serv = new ArrayList<>();
    Biglietto biglietto = new Biglietto();
    biglietto.setCodiceVisita(db.getEventoById(visita));
    biglietto.setDataValidita(dataValidita);
    biglietto.setCodiceCategoria(db.getCategoriaById(codiceCategoria));
    biglietto.setNomeUtente(db.getUtenteByNome(nomeUtente));
    if (servizi != null) {
      for (Integer i : servizi) {
        serv.add(db.getServizioById(i));
      }//for
      biglietto.setServiziCollection(serv);
    }
    carrello.add(biglietto);
    //db.salvaBiglietto(biglietto);
    System.out.println(biglietto);
    map.put("tikets", carrello);
    return "redirect:/bigliettiPrenotati";
  }
}
