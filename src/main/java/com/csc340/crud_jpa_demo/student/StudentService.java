package com.csc340.crud_jpa_demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * StudentService is a service class that handles the business logic for
 * managing students.
 * It provides methods to perform CRUD operations on student data.
 */
@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  /**
   * Method to get all students
   *
   * @return List of all students
   */
  public Object getAllStudents() {
    return studentRepository.findAll();
  }

  /**
   * Method to get a student by ID
   *
   * @param studentId The ID of the student to retrieve
   * @return The student with the specified ID
   */
  public Student getStudentById(@PathVariable long studentId) {
    return studentRepository.findById(studentId).orElse(null);
  }

  /**
   * Method to get students by name
   *
   * @param name The name of the student to search for
   * @return List of students with the specified name
   */
  public Object getStudentsByName(String name) {
    return studentRepository.getStudentsByName(name);
  }

  /**
   * Method to get students by major
   *
   * @param major The major to search for
   * @return List of students with the specified major
   */
  public Object getStudentsByMajor(String major) {
    return studentRepository.getStudentsByMajor(major);
  }

  /**
     * Fetch all students with a GPA above a threshold.
     *
     * @param gpa the threshold
     * @return the list of matching Students
     */
    public Object getHonorsStudents(double gpa) {
        return studentRepository.getHonorsStudents(gpa);
    }

  /**
   * Method to add a new student
   *
   * @param student The student to add
   */
  public Student addStudent(Student student) {
    return studentRepository.save(student);
  }

  /**
   * Method to update a student
   *
   * @param studentId The ID of the student to update
   * @param student   The updated student information
   */
  public Student updateStudent(Long studentId, Student student) {
    return studentRepository.save(student);
  }

  /**
   * Method to delete a student
   *
   * @param studentId The ID of the student to delete
   */
  public void deleteStudent(Long studentId) {
    studentRepository.deleteById(studentId);
  }

}
