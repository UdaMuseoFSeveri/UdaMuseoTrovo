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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccessoController {

  private Database db = new Database();

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage(ModelMap map) {
    return "login";
  }

  @RequestMapping(value = "/verificaLogin", method = RequestMethod.POST)
  public String verificaLogin(ModelMap map, @RequestParam(value = "utente", required = true) String nomeUtente, @RequestParam(value = "password", required = true) String password) {
    String passwordCifrata = db.cifraPassword(password);

    if (nomeUtente != null && passwordCifrata != null) {
      int i;
      i = db.verificaUtente(new Utente(nomeUtente, passwordCifrata));
      if (i == 1) {
        map.put("risposta", "Il nome utente è inesistente");
      } else if (i == 0) {
        //login affettuato correttamente
        map.put("username", nomeUtente);
        map.put("accesso", true);
      } else {
        map.put("risposta", "La password è errata");
        return "login";

      }
    }
    return "login";
  }

  @RequestMapping(value = "/registra", method = RequestMethod.POST)
  public String registra(ModelMap map, @RequestParam(value = "utente", required = true) String nomeUtente, @RequestParam(value = "password", required = true) String password, @RequestParam(value = "verificaPassword", required = true) String verificaPassword) {
    String pass = db.cifraPassword(password);
    String verPassword = db.cifraPassword(verificaPassword);

    if (0 == db.utenteEsistente(nomeUtente)) {
      if (pass.equals(verPassword)) {
        db.salvaUtente(new Utente(nomeUtente, pass));
        return "login";
      } else {
        map.put("risposta", "La password non coincide");
      }
    } else {
      map.put("risposta", "Nome utente già esistente");
    }
    return "login";

  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(ModelMap map) {
    return "logout";
  }
}
