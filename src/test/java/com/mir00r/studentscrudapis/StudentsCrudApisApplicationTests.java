package com.mir00r.studentscrudapis;

import com.mir00r.studentscrudapis.domains.students.models.dtos.StudentDto;
import com.mir00r.studentscrudapis.domains.students.models.entites.Student;
import com.mir00r.studentscrudapis.domains.students.services.IStudentService;
import com.mir00r.studentscrudapis.routes.Router;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class})
@SpringBootTest(classes = {
        StudentsCrudApisApplication.class,
        URI.class
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentsCrudApisApplicationTests extends AbstractTest {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    public void shouldReturnNotNullGameService() {
        Assertions.assertNotNull(studentService);
    }

    @Test
    @Order(2)
    @DisplayName("Test Creating Student")
    public void testCreateTickets() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String body = "{ \"name\": \"Jhon Abraham\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<StudentDto> response = this.testRestTemplate.postForEntity(baseUrl + port + Router.CREATE_STUDENTS, request, StudentDto.class);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());

        logger.info(response.getBody().toString());
    }
}
