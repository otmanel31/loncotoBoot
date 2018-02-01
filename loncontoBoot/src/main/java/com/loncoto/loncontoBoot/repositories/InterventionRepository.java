package com.loncoto.loncontoBoot.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.loncoto.loncontoBoot.metier.Intervention;

public interface InterventionRepository extends PagingAndSortingRepository<Intervention, Integer> {
	Page<Intervention> findByStatusEquals(String status, Pageable page);
	//Page<Intervention> findByEquipment
	Page<Intervention> findByEquipmentClientNameEquals(String name, Pageable p);
	Page<Intervention> findByDateOfCompletionEquals(LocalDateTime dateOfCompletion, Pageable p);
	Page<Intervention> findByIntervenantFirstnameEquals(String firstname, Pageable p);
	Page<Intervention> findByInterventionDateEquals(LocalDateTime interventionDate, Pageable p);
// on chercher a +1/-1 jours de la mission qu on souhaite programmer pour ne pas 
	// se retoruver avc un traitement lourd + filtre approfondi par programmation dans le service
	List<Intervention> findByIntervenantIdAndInterventionDateAndDateOfCompletion(int id, LocalDateTime start, LocalDateTime end);
}
