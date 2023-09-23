package com.ey.apigateway;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ey.apigateway.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ApiGatewayApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    @Mock
    Employee employee;
    
	@Test
	public void employeeSignUpTest(){
//		Employee empObj= new Employee("Kshirabdhi","Sayanam","ksh@gmail.com","pass");
//		
//		
//		String json;
//		try {
//			json = objectMapper.writeValueAsString(empObj);
//			mockMvc.perform(MockMvcRequestBuilders
//					.post("http://localhost:8081/user/signUp")
//				    	.contentType(MediaType.APPLICATION_JSON)
//				    		.content(json))
//				    			.andExpect(status().isOk())
//				    				.andExpect(MockMvcResultMatchers.content().string("Successfully Signed Up"));
//		} catch (JsonProcessingException e) {
//			System.out.print(e.getCause());
//		} catch (Exception e) {
//			System.out.print(e.getCause());
//		}

    
	}
}
