package com.loncoto.loncontoBoot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.loncoto.loncontoBoot.metier.Materiel;

public interface MaterielRepository extends PagingAndSortingRepository<Materiel, Integer> {

}
