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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(ModelMap map, @RequestParam(value = "utente", required = false) String nomeUtente, @RequestParam(value = "password", required = false) String password) {
        if(nomeUtente != null && password != null ){
            int i;
            i = db.verificaUtente(new Utente(nomeUtente, password));
           /**
            String s= ""+i;
            map.put("risposta",s);
            map.put("utente",nomeUtente);
            **/

            if (i == 1) {
                map.put("risposta","Il nome utente è inesistente");

            }
            else if (i == 0) {
                //login affettuato correttamente
               map.put("username",nomeUtente);
               map.put("accesso",true);
            }else{
               map.put("risposta","La password è errata");
               return "login";

            }
        }
        return "login";
    }

    @RequestMapping(value = "/verificaLogin", method = RequestMethod.POST)
    public String verificaLogin(ModelMap map, @RequestParam(value = "utente", required = true) String nomeUtente, @RequestParam(value = "password", required = true) String password) {
        int i;
        i = db.verificaUtente(new Utente(nomeUtente, password));
       /**
        String s= ""+i;
        map.put("risposta",s);
        map.put("utente",nomeUtente);
        **/
        
        if (i == 1) {
            map.put("risposta","Il nome utente è inesistente");
            return "login";

        }
        else if (i == 0) {
           map.put("username",nomeUtente);
           map.put("password",password);
           return "accessoEffettuato";

        }else{
           map.put("risposta","La password è errata");
           return "login";

        }
        

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
