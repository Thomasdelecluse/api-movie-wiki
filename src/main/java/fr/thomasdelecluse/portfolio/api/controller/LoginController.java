package fr.thomasdelecluse.portfolio.api.controller;

import fr.thomasdelecluse.portfolio.api.dto.TokenDTO;
import fr.thomasdelecluse.portfolio.api.repository.UtilisateurRepository;
import fr.thomasdelecluse.portfolio.api.model.Utilisateur;
import fr.thomasdelecluse.portfolio.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    TokenService generator;
    @GetMapping("/")
    List<Utilisateur> getAll() {
        return StreamSupport.stream(utilisateurRepository.findAll().spliterator(), false).toList();
    }

    @DeleteMapping("/util/{id}")
    void deleteEmployee(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
    }

    @PostMapping("/login")
    Object newlogin(@RequestBody Utilisateur newUtilisateur) {
        String mdp = newUtilisateur.getMdp();
        String email = newUtilisateur.getEmail();

        Iterable<Utilisateur> db = utilisateurRepository.findAll();
        for (Utilisateur utilisateur : db) {
            if (utilisateur.getEmail().equals(email) && utilisateur.getMdp().equals(mdp))
            {
                String token = generator.nextToken();
                utilisateur.setToken(token);
                Date date = new Date();
                utilisateur.setCreation_date(date);
                utilisateurRepository.save(utilisateur);
                return new TokenDTO(token);
            }
        }
        return "aucun utilisateur trouvé";
    }

    @PostMapping("/register")
    Utilisateur newUtilisateur(@RequestBody Utilisateur newUtilisateur) {
        return utilisateurRepository.save(newUtilisateur);
    }

}
