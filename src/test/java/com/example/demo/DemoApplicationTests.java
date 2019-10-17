package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
	

    
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;
    
     int studentId = 1;
     String firstName="Rajan";
     String lastName="Subedi";
	 String gender="male";
	 String maritalStatus="unmarried";
     String email="rajan.subedi@hcl.com";
     
     
     @Test
     public void testGetStudent1() throws Exception {

    	 int studentId = 1;
         String firstName="Rajan";
         String lastName="Subedi";
    	 String gender="male";
    	 String maritalStatus="unmarried";
         String email="rajan.subedi@hcl.com";
         long phone = 789962995;
         Student stu = new Student(studentId,firstName,lastName,gender,maritalStatus,email,phone);
       
         Mockito.when(studentService.getStudent(Mockito.anyInt())).thenReturn(stu);


         //response is retrieved as MvcResult
         mockMvc.perform(get("/api/student/getStudent/{id}", studentId)
                 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.studentId", CoreMatchers.is(studentId)))
                 .andExpect(jsonPath("$.firstName", CoreMatchers.is(firstName)))
                 .andExpect(jsonPath("$.lastName", CoreMatchers.is(lastName)));
     }

    
	  @Test
	  public void contextLoads() {
	  }
	
	

}
