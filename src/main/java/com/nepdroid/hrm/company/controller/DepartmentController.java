package com.nepdroid.hrm.company.controller;

import com.nepdroid.hrm.company.model.DepartmentModel;
import com.nepdroid.hrm.company.repository.DepartmentRepository;
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
* simply performs CRUD operations for Department Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class DepartmentController {

  @Autowired
  DepartmentRepository departmentRepository;
  
  /**
   * This is a method to register department details.
   * @param departmentModel This is a parameter to registerDepartment method.
   * @param result This is a parameter to registerDepartment method.
   * @return ResponseEntity This returns response of registering department model. 
   */
  @PostMapping("/registerDepartment")
  public ResponseEntity<Response> registerDepartment(@Valid @RequestBody DepartmentModel 
      departmentModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {
   
        departmentRepository.save(departmentModel);
        response.setStatus(true);
        response.setDepartmentModel(departmentModel);
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
   * This is a method to update department details.
   * @param departmentModel This is a parameter to updateDepartment method.
   * @param result This is a parameter to updateDepartment method.
   * @return ResponseEntity This returns response of updating department.
   */
  @PutMapping("/updateDepartment")
  public ResponseEntity<Response> updateDepartment(@Valid @RequestBody DepartmentModel 
      departmentModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {
   
      try {
        
        if (departmentRepository.existsById(departmentModel.getDepartmentId())) {
          departmentRepository.save(departmentModel); 
          response.setStatus(true);
          response.setDepartmentModel(departmentModel);
        } else {
          throw new Exception();
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
   * This is a method to delete department detail by id.
   * @param departmentId This is a parameter to deleteDepartment method.
   * @return ResponseEntity This returns response of deleting department by id.
   */
  @DeleteMapping("/deleteDepartment/{departmentId}")
  public ResponseEntity<Response> deleteDepartment(@PathVariable("departemntId") 
        String departmentId) {

    Response response = new Response();
    DepartmentModel departmentModel = departmentRepository.findById(departmentId).get();
    if (departmentModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Employee Department with id:" 
            + departmentId + "not found");
    }
    departmentRepository.delete(departmentModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response,HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all department details. 
   * @return ResponseEntity This returns response of fetching department model list
   */
  @GetMapping("/getAllDepartment")
  public ResponseEntity<List<DepartmentModel>> getAllDepartment() {
    
    List<DepartmentModel> list = departmentRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<DepartmentModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<DepartmentModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch department detail by id.
   * @param departmentId This is a parameter to getByDepartmentId method
   * @return ResponseEntity This returns response of fetching department by id
   */
  @GetMapping("/getByDepartmentId/{departmentId}")
  public ResponseEntity<DepartmentModel> getByDepartmentId(@PathVariable("departmentId") 
        String departmentId) {

    DepartmentModel departmentModel = departmentRepository.findById(departmentId).get();
    if (departmentModel == null) {
      throw new ResourceNotFoundException("Employee Department with Id:" + departmentId 
          + "not found");
    }
    return new ResponseEntity<DepartmentModel>(departmentModel,HttpStatus.OK);
  }
}
