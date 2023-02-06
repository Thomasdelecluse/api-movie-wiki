package fr.thomasdelecluse.portfolio.api.repository;

import fr.thomasdelecluse.portfolio.api.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
}
