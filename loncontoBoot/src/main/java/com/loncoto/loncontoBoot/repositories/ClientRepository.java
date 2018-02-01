package com.loncoto.loncontoBoot.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.loncoto.loncontoBoot.metier.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

}
