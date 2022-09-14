package cardxMania.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cardxMania.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer> {


	public Optional<Compte> findByPseudo (String pseudo);
	public Optional<Compte> findByPseudoAndPassword(String pseudo, String password);
//
//	@Modifying
//	@Transactional
//	@Query("delete from Compte c where c.pseudo=:pseudo")
//	public void deleteByCompte(@Param("pseudo") String pseudo);

//	@Modifying
//	@Transactional
//	@Query ("SELECT c from Compte c where c.pseudo=:pseudo and c.password=:password")
//	public void seConnecter(@Param("pseudo")String pseudo, @Param("password")String password);
}
