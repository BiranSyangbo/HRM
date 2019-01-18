package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.EmployeeModel;
import com.nepdroid.hrm.employee.repository.EmployeeRepository;
import com.nepdroid.hrm.entity.Response;
import com.nepdroid.hrm.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
* This class program implements an application that
* simply performs CRUD operations for Employee Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class EmployeeController {

  @Autowired
  EmployeeRepository employeeRepository;

  /**
   * This is a method to register Employee details
   * upon request.
   * @param employeeModel This is a parameter to registerEmployee method.
   * @param result This is a parameter to registerEmployee method.
   * @return ResponseEntity This returns response of registering Employee.  
   */
  @PostMapping("/registerEmployee")
  public ResponseEntity<Response> registerEmployee(@Valid @RequestBody EmployeeModel employeeModel, 
      Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      // Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {
    
      // Implement business logic to save employee into database
      try {

        employeeRepository.save(employeeModel);
        response.setStatus(true);
        response.setEmployeeModel(employeeModel);

      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setStatus(false);
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

      }
      return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }
  }

  /**
   * This is a method to update Employee details
   * upon request.
   * @param employeeModel This is a parameter to updateEmployee method.
   * @param result This is a parameter to updateEmployee method.
   * @return ResponseEntity This returns response of updating Employee.  
   */
  @PutMapping("/updateEmployee")
  public ResponseEntity<Response> updateEmployee(@Valid @RequestBody EmployeeModel employeeModel, 
      Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      // Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {
    
      // Implement business logic to save employee into database
      try {

        if (employeeRepository.existsById(employeeModel.getEmployeeId())) {
          employeeRepository.save(employeeModel);
          response.setStatus(true);
          response.setEmployeeModel(employeeModel);  
        }

      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setStatus(false);
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

      }
      return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
  }

  /**
   * This is a method to delete employee detail based on id.
   * @param employeeId This is a parameter to deleteEmployee method.
   * @return ResponseEntity This returns response of deleting Employee.
   */
  @DeleteMapping("/deleteEmployee/{employeeId}")
  public ResponseEntity<Response> deleteEmployee(@PathVariable("employeeId") String employeeId) {

    EmployeeModel employeeModel = employeeRepository.findById(employeeId).get();
    Response response = new Response();
    if (employeeModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Employee with id:" 
            + employeeId + "not found");
    }
    employeeRepository.delete(employeeModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all employee details. 
   * @return ResponseEntity This returns response of fetching employees list
   */
  @GetMapping("/getAllEmployee")
  public ResponseEntity<List<EmployeeModel>> getAllEmployee() {

    List<EmployeeModel> list = employeeRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<EmployeeModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<EmployeeModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch employee detail by id.
   * @param employeeId This is a parameter to getByEmployeeId method.
   * @return ResponseEntity This returns response of fetching employee by id. 
   */
  @GetMapping("/getByEmployeeId/{employeeId}")
  public ResponseEntity<EmployeeModel> getByEmployeeId(@PathVariable("employeeId") 
      String employeeId) {
  
    EmployeeModel employeeModel = employeeRepository.findById(employeeId).get();
    if (employeeModel == null) {
      throw new ResourceNotFoundException("Employee with id:" + employeeId + "not found");
    }
    return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
  }

}
