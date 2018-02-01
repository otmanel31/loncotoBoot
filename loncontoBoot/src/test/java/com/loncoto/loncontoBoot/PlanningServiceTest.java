package com.loncoto.loncontoBoot;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.loncoto.loncontoBoot.metier.Intervenant;
import com.loncoto.loncontoBoot.metier.Intervention;
import com.loncoto.loncontoBoot.repositories.InterventionRepository;
import com.loncoto.loncontoBoot.services.PlannificatorService;
import com.loncoto.loncontoBoot.services.PlannificatorService.IntervenantAvailableException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=TestConfiguration.class)
public class PlanningServiceTest {

	@Autowired
	private InterventionRepository interventionDao;
	
	private PlannificatorService plannificatorService;
	
	private List<Intervenant> getSampleIntervanant(){
		return new ArrayList<>(Arrays.asList(
				new Intervenant(1, "otman", "ot"),
				new Intervenant(2, "toto", "to")
			)
		);
	}
	
	private List<Intervention> getSampleInterventions(){
		Intervenant i1 = new Intervenant(1, "bob", "bob@bikinibottom.com");
		Intervenant i2 = new Intervenant(2, "patrick", "patrick@bikinibottom.com");
		List<Intervention> data = new ArrayList<>();
		Intervention inter = new Intervention(1, "1A", LocalDateTime.now(), LocalDateTime.now().plusHours(2), "pending", "no comment");
		inter.setIntervenant(i1);
		data.add(inter);
		inter = new Intervention(2, "2A", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4), "pending", "no comment");
		inter.setIntervenant(i1);
		data.add(inter);
		
		inter = new Intervention(3, "3A", LocalDateTime.now(), LocalDateTime.now().plusHours(2), "pending", "no comment");

		inter.setIntervenant(i2);
		data.add(inter);
		
		return data;
	}
	
	@Before
	public void before() {
		this.plannificatorService = new PlannificatorService();
		this.plannificatorService.setInterventionDao(interventionDao);
	}
	
	@Test
	public void testPlannificationInterventionOk() {
		// AJOUT ICI test interdaofindBy ... 
		
		Intervention i = new Intervention(4, "1A", LocalDateTime.now().minusHours(3), LocalDateTime.now().minusHours(1), "pending", "no comment");
		i.setIntervenant(getSampleIntervanant().get(0));
		Intervention i2 = getSampleInterventions().get(1);
		
		Mockito.when(interventionDao.save(Mockito.any(Intervention.class)))
			.thenReturn(i);
		
		Intervention result = this.plannificatorService.plannifier(i);
		assertEquals(i, result);
		
		Mockito.verify(interventionDao,  Mockito.atLeastOnce()).save(Mockito.any(Intervention.class));
		
	}
	
	@Test(expected=IntervenantAvailableException.class)
	public void testPlannificationInterventionWithIntervenantNotAvailable() {
		
		Mockito.when(this.interventionDao.findByIntervenantIdAndInterventionDateAndDateOfCompletion(
				Mockito.eq(1), Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class)))
			.thenReturn(
					getSampleInterventions()
					.stream()
					.filter(interv-> interv.getIntervenant().getId() == 1)
					.collect(Collectors.toList())
			);
					
		Intervention inter = new Intervention(5, "1A", LocalDateTime.now(), LocalDateTime.now().plusHours(2), "pending", "no comment");
		inter.setIntervenant(getSampleIntervanant().get(0));
		
		Intervention result = this.plannificatorService.plannifier(inter);
		
		
	}
}
 