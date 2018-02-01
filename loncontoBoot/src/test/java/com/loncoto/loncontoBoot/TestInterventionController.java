package com.loncoto.loncontoBoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.loncoto.loncontoBoot.controller.InterventionController;
import com.loncoto.loncontoBoot.metier.Intervenant;
import com.loncoto.loncontoBoot.metier.Intervention;
import com.loncoto.loncontoBoot.repositories.InterventionRepository;
import com.loncoto.loncontoBoot.services.PlannificatorService;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.hasSize; // test sur du contenu json
import static org.hamcrest.Matchers.equalTo; // test sur du contenu json
import static org.hamcrest.Matchers.closeTo; // test sur du contenu json

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=InterventionController.class)
@EnableSpringDataWebSupport
public class TestInterventionController {

	@MockBean
	private InterventionRepository interventionDao;
	
	@MockBean
	private PlannificatorService planifService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private Page<Intervention> getSampleInterventions(Pageable p, int total){
		Intervenant it1 = new Intervenant(2, "otman", "titi");
		Intervenant it2 = new Intervenant(2, "maurille", "titi");
		Intervention i1 = new Intervention(1, "afz11", LocalDateTime.now(), LocalDateTime.now().plusHours(1), "pending", "no commen");
		i1.setIntervenant(it1);
		Intervention i2 = new Intervention(2, "afz11", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3), "pending", "no commen");
		i2.setIntervenant(it1);
		Intervention i3 = new Intervention(3, "afz11", LocalDateTime.now(), LocalDateTime.now().plusHours(1), "pending", "no commen");
		i3.setIntervenant(it2);
		Intervention i4 = new Intervention(4, "afz11", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(3), "pending", "no commen");
		i4.setIntervenant(it2);
		Intervention i5 = new Intervention(5, "afz11", LocalDateTime.now().minusHours(3), LocalDateTime.now().minusHours(1), "pending", "no commen");
		i5.setIntervenant(it1);
		
		int start = p.getOffset(); 
		return new PageImpl<>(
				new ArrayList<>(Arrays.asList(i1, i2, i3, i4, i5)),
				p, 
				total
		);
	}
	
	@Test
	public void testFindAllPaginate() throws Exception {
		Pageable pr = new PageRequest(0, 2);
		Mockito.when(interventionDao.findAll(Mockito.any(Pageable.class)))
			.thenReturn(getSampleInterventions(pr, 5));
		
		mockMvc.perform(get("/extended_api/interventions/pliste")
				.param("page", "0")
				.param("size", "2")
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(jsonPath("$.content[0].id" , equalTo(1)));
	}
}
