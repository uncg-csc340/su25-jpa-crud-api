package com.csc340.crud_jpa_demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController is a REST controller that handles HTTP requests related to
 * students.
 * It provides endpoints for CRUD operations on student data.
 */
@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;

  /**
   * Endpoint to get all students
   *
   * @return List of all students
   */
  @GetMapping("/students")
  public Object getAllStudents() {
    return studentService.getAllStudents();
  }

  /**
   * Endpoint to get a student by ID
   *
   * @param id The ID of the student to retrieve
   * @return The student with the specified ID
   */
  @GetMapping("/students/{id}")
  public Student getStudentById(@PathVariable long id) {
    return studentService.getStudentById(id);
  }

  /**
   * Endpoint to get students by name
   *
   * @param name The name of the student to search for
   * @return List of students with the specified name
   */
  @GetMapping("/students/name")
  public Object getStudentsByName(@RequestParam String key) {
    return studentService.getStudentsByName(key);
  }

  /**
   * Endpoint to get students by major
   *
   * @param major The major to search for
   * @return List of students with the specified major
   */
  @GetMapping("/students/major/{major}")
  public Object getStudentsByMajor(@PathVariable String major) {
    return studentService.getStudentsByMajor(major);
  }

  /**
   * Endpoint to add a new student
   *
   * @param student The student to add
   * @return List of all students
   */
  @PostMapping("/students")
  public Object addStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
  }

  /**
   * Endpoint to update a student
   *
   * @param id      The ID of the student to update
   * @param student The updated student information
   * @return The updated student
   */
  @PutMapping("/students/{id}")
  public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
    studentService.updateStudent(id, student);
    return studentService.getStudentById(id);
  }

  /**
   * Endpoint to delete a student
   *
   * @param id The ID of the student to delete
   * @return List of all students
   */
  @DeleteMapping("/students/{id}")
  public Object deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return studentService.getAllStudents();
  }

}
