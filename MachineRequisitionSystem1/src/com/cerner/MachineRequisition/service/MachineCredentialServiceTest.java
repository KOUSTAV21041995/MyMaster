package com.cerner.MachineRequisition.service;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cerner.MachineRequisition.Dao.MachineCredentialsDao;
import com.cerner.MachineRequisition.Model.MachineCredentials;
import com.cerner.MachineRequisition.controllers.MachineCredentialController;
import com.cerner.MachineRequisition.service.impl.MachineCredentialServiceImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;




import junit.framework.TestCase;

public class MachineCredentialServiceTest extends TestCase {
	/*@Mock
	MachineCredentialsDao dao;*/
	private MockMvc mvc;

	@Mock 
	MachineCredentialServiceImpl impl;
	@InjectMocks
    private MachineCredentialController controller;
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		mvc=MockMvcBuilders.standaloneSetup
				(new MachineCredentialController()).
				setViewResolvers(viewResolver()).
				build();
        MachineCredentials mc=new MachineCredentials();
		
		mc.setDivname("HR");
		mc.setIpAddress("172.10.10.2");
		Mockito.when(impl.getDivNamebyIP(mc.getIpAddress())).thenReturn(mc.getDivname());
		
	}
	private ViewResolver viewResolver() {
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver.setViewClass(JstlView.class);
		viewresolver.setPrefix("/WEB-INF/Views/");
		viewresolver.setSuffix(".jsp");
		return viewresolver;
	}
	@Test
	public void testdivnamebyip() throws Exception {
		
		MachineCredentials mc=new MachineCredentials();
		
		mc.setDivname("HR");
		mc.setIpAddress("172.10.10.2");

		  mvc.perform(post("/credentialbyIP"));
		             .andExpect(status().isOk());
		      
				
	}
	
}
