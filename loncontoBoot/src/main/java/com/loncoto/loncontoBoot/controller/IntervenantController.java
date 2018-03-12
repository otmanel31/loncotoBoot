package com.loncoto.loncontoBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loncoto.loncontoBoot.metier.Intervenant;
import com.loncoto.loncontoBoot.repositories.IntervenantRepository;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value="/extended_api/intervenants")
@Log4j
public class IntervenantController {
	
	@Autowired
	private IntervenantRepository intervenantRepository;
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Intervenant> findAll(){
		List<Intervenant> its = new ArrayList<>();
		this.intervenantRepository.findAll().forEach(its::add);
		return its;
	}
}
