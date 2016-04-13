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
        int i;
        i = db.verificaUtente(new Utente(nomeUtente, password));
        if (i == 1) {
            return "login?indb=false";
        }
        if (i == 0) {
            return "/";
        }
        return "login?pswdErr=true";

    }

    @RequestMapping(value = "/registra", method = RequestMethod.POST)
    public String registra(ModelMap map, @RequestParam(value = "utente", required = true) String nomeUtente, @RequestParam(value = "password", required = true) String password, @RequestParam(value = "verificaPassword", required = true) String verificaPassword) {
        if (0 == db.utenteEsistente(nomeUtente)) {
            if (password.equals(verificaPassword)) {
                db.salvaUtente(new Utente(nomeUtente, password));
                return "homepage";
            } else {
                return "login?errorPass=true";
            }
        } else {
            return "login?dupplicate=true";
        }
    }
}
