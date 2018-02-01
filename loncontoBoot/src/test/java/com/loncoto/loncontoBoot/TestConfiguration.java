package com.loncoto.loncontoBoot;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loncoto.loncontoBoot.metier.Intervention;
import com.loncoto.loncontoBoot.repositories.InterventionRepository;

@Configuration
public class TestConfiguration {

	@Bean
	public InterventionRepository interventionDao() {
		return Mockito.mock(InterventionRepository.class);
	}
}
