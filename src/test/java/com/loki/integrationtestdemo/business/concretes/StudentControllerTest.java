package com.loki.integrationtestdemo.business.concretes;

import com.loki.integrationtestdemo.BaseControllerTest;
import com.loki.integrationtestdemo.IntegrationTestDemoApplication;
import com.loki.integrationtestdemo.containers.IntegrationTestDemoMysqlContainer;
import org.junit.ClassRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest(classes = {IntegrationTestDemoApplication.class},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("junit")
public class StudentControllerTest extends BaseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@ClassRule
	protected static IntegrationTestDemoMysqlContainer container = IntegrationTestDemoMysqlContainer
			.getInstance();

	private String baseUrl = "/api/students";

	@Test
	@DisplayName("Post Student Then Success")
	void postStudentThenSuccess() throws Exception{
		String data = loadFile("payloads/student-valid.json");
		addStudent(data).andExpect(status().is(HttpStatus.CREATED.value()));
	}

	@Test
	@DisplayName("When Duplicate NationalityId Was Given Throw Error ")
	void whenDuplicateNationalityIdWasGivenThrowError() throws Exception{
		postStudentThenSuccess();
		String data = loadFile("payloads/student-valid.json");
		addStudent(data).andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
	}


	@Test
	@DisplayName("GET A Student By Id")
	void getAStudentById() throws Exception{

		postStudentThenSuccess();
		mockMvc.perform(get(baseUrl + "/1").with(getHeaders()))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(HttpStatus.OK.value()));
	}

	@Test
	@DisplayName("GET Non Exists Id And Throw Exception")
	void getNonExistsIdAndThrowException() throws Exception{
		mockMvc.perform(get(baseUrl + "/2").with(getHeaders()))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is(HttpStatus.NOT_FOUND.value()));
	}





	private ResultActions addStudent(String data) throws Exception{
		//String data = loadFile("payloads/student-valid.json");
		return mockMvc.perform(post(baseUrl)
						.with(postHeaders()).content(data))
				.andDo(MockMvcResultHandlers.print());
				//.andExpect(status().is(HttpStatus.CREATED.value()));
	}




}
