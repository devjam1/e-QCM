package com.javaee.eqcm.controller;

import com.javaee.eqcm.entity.Etudiant;
import com.javaee.eqcm.entity.Utilisateur;
import com.javaee.eqcm.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/inscription")
public class RegisterController {

    @Autowired
    private UtilisateurService utilisateurService ;


    @ModelAttribute("etudiant")
    public Utilisateur constructUser() {
        return new Etudiant();
    }

    @RequestMapping
    public String showRegister() {
        return "inscription";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("etudiant") Etudiant etudiant, RedirectAttributes redirectAttributes) {
        utilisateurService.save(etudiant);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/inscription.html";
    }

    @RequestMapping("/valable")
    @ResponseBody
    public String available(@RequestParam String login){
        Boolean valable = utilisateurService.findOne(login) == null;
        return valable.toString();
    }
}
