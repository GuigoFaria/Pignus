package br.com.pignus.pignusproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{

	@Query("from Setor where nomeSetor = ?1")
	List<Setor> findByNomeLista(String nomeSetor);
	@Query("from Setor")
	List<Setor> findAllById(int id);
	@Query("from Setor")
	List<Download> findAllByIdDownload(int id);
	@Query("from Setor where nomeSetor = ?1")
	String findByNome(String nomeSetor);




	

	
    
}