/**
 * This is the Request Page Controller test class
 * 
 * @author Varsha Das
 */

package javaTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.cerner.MachineRequisition.Model.RequestDetails;
import com.cerner.MachineRequisition.controllers.RequestPagecontroller;

public class RequestPageControllerTest {
	private MockMvc mockmvc;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(new RequestPagecontroller()).setViewResolvers(viewResolver()).build();

	}

	private ViewResolver viewResolver() {
		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setViewClass(JstlView.class);
		viewresolver.setPrefix("/WebContent/WEB-INF/Views/");
		viewresolver.setSuffix(".jsp");
		return viewresolver;
	}

	/**
	 * The function tests the Home page
	 * 
	 * @throws Exception
	 * @return Nothing
	 */
	@Test
	public void testhomepage() throws Exception {
		mockmvc.perform(get("/").sessionAttr("request", new RequestDetails())).andExpect(status().isOk())
				.andExpect(view().name("index"));

	}
}
