package com.loncoto.loncontoBoot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.loncoto.loncontoBoot.metier.Famille;

public interface FamilleRepository extends PagingAndSortingRepository<Famille, Integer> {

}
