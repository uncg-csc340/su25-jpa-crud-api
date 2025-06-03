package com.csc340.crud_jpa_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.csc340.crud_jpa_demo.student.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTests {

  @Autowired
  private TestRestTemplate restTemplate;

  private final String BASE_URL = "/students";

  @Test
  public void testCreateStudent() {
    Student student = new Student("Test Student", "test@uncg.edu", "Biology", 3.5);
    ResponseEntity<Student> response = restTemplate.postForEntity(BASE_URL, student, Student.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response);
  }

  @Test
  public void testReadEntity() {
    ResponseEntity<Student[]> response = restTemplate.getForEntity(BASE_URL,
        Student[].class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(response.getBody().length > 0);
  }

  @Test
  public void testUpdateEntity() {
    Student student = new Student(1l, "Test Student Updated", "test@uncg.edu", "Biology", 3.5);
    restTemplate.put(BASE_URL + "/1", student);

    ResponseEntity<Student> updatedResponse = restTemplate.getForEntity(BASE_URL +
        "/1", Student.class);
    assertEquals("Test Student Updated", updatedResponse.getBody().getName());
  }

  @Test
  public void testDeleteEntity() {
    restTemplate.delete(BASE_URL + "/1");

    ResponseEntity<Student> response = restTemplate.getForEntity(BASE_URL + "/1",
        Student.class);
    assertEquals(null, response.getBody());
  }

}
