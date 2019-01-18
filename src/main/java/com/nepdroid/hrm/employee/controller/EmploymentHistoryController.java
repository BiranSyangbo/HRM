package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.EmploymentHistoryModel;
import com.nepdroid.hrm.employee.repository.EmploymentHistoryRepository;
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
* simply performs CRUD operations for Employee's Employment History Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class EmploymentHistoryController {

  @Autowired
  EmploymentHistoryRepository employmentHistoryRepository;

  /**
   * This is a method to register Employment History details.
   * @param employmentHistoryModel This is a parameter to registerEmploymentHistory method.
   * @param result This is a parameter to registerEmploymentHistory method.
   * @return ResponseEntity This returns response of registering Employment History model. 
   */
  @PostMapping("/registerEmploymentHistory")
  public ResponseEntity<Response> registerEmploymentHistory(@Valid @RequestBody 
      EmploymentHistoryModel employmentHistoryModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
    
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      
    } else {
 
      try {
    
        employmentHistoryRepository.save(employmentHistoryModel);
        response.setStatus(true);
        response.setEmploymentHistoryModel(employmentHistoryModel);
        
      } catch (Exception ex) {
    
        Map<String, String> errors = new HashMap<>();
        errors.put("Error message:", ex.toString());
        response.setStatus(false);
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }
  }
  
  /**
   * This is a method to update Employment History details.
   * @param employmentHistoryModel This is a parameter to updateEmploymentHistory method.
   * @param result This is a parameter to updateEmploymentHistory method.
   * @return ResponseEntity This returns response of updating Employment History model. 
   */
  @PutMapping("/updateEmploymentHistory")
  public ResponseEntity<Response> updateEmploymentHistory(@Valid @RequestBody 
      EmploymentHistoryModel employmentHistoryModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
    
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      
    } else {
 
      try {
        if (employmentHistoryRepository.existsById(employmentHistoryModel
             .getEmploymentHistoryId())) {
       
          employmentHistoryRepository.save(employmentHistoryModel);
          response.setStatus(true);
          response.setEmploymentHistoryModel(employmentHistoryModel);
          
        } else {
          throw new Exception();
        }
        
      } catch (Exception ex) {
    
        Map<String, String> errors = new HashMap<>();
        errors.put("Error message:", ex.toString());
        response.setStatus(false);
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
  }
  
  /**
   * This is a method to delete Employment History detail based on id.
   * @param employmentHistoryId This is a parameter to deleteEmploymentHistory method.
   * @return ResponseEntity This returns response of deleting Employment History.
   */
  @DeleteMapping("/deleteEmploymentHistory/{employmentHistoryId}")
  public ResponseEntity<Response> deleteEmploymentHistory(@PathVariable("employmentHistoryId") 
        String employmentHistoryId) {

    EmploymentHistoryModel employmentHistoryModel = employmentHistoryRepository
        .findById(employmentHistoryId).get();
    Response response = new Response();
    if (employmentHistoryModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Employment History with id:"
         + employmentHistoryId + "not found");
    } 
    employmentHistoryRepository.delete(employmentHistoryModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all Employment History details. 
   * @return ResponseEntity This returns response of fetching Employment History model list
   */
  @GetMapping("/getAllEmploymentHistory")
  public ResponseEntity<List<EmploymentHistoryModel>> getAllEmploymentHistory() {

    List<EmploymentHistoryModel> list = employmentHistoryRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<EmploymentHistoryModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<EmploymentHistoryModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch Employment History detail by id.
   * @param employmentHistoryId This is a parameter to getByEmploymentHistoryId method.
   * @return ResponseEntity This returns response of fetching Employment History model. 
   */ 
  @GetMapping("/getByEmploymentHistoryId/{employmentHistoryId}")
  public ResponseEntity<EmploymentHistoryModel> getByEmploymentHistoryId(
      @PathVariable("employmentHistoryId") String employmentHistoryId) {

    EmploymentHistoryModel employmentHistoryModel = employmentHistoryRepository
           .findById(employmentHistoryId).get();
    if (employmentHistoryModel == null) {
      throw new ResourceNotFoundException("Employment History with Id:" 
           + employmentHistoryId + "not found");
    }
    return new ResponseEntity<EmploymentHistoryModel>(employmentHistoryModel, HttpStatus.OK);
  }

}
