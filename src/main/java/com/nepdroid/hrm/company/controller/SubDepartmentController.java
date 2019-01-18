package com.nepdroid.hrm.company.controller;

import com.nepdroid.hrm.company.model.SubDepartmentModel;
import com.nepdroid.hrm.company.repository.SubDepartmentRepository;
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
* simply performs CRUD operations for Sub Department Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class SubDepartmentController {

  @Autowired
  SubDepartmentRepository subDepartmentRepository;
  
  /**
   * This is a method to register sub department details.
   * @param subDepartmentModel This is a parameter to registerSubDepartment method.
   * @param result This is a parameter to registerSubDepartment method.
   * @return ResponseEntity This returns response of registering sub department model. 
   */
  @PostMapping("/registerSubDepartment")
  public ResponseEntity<Response> registerSubDepartment(@Valid @RequestBody SubDepartmentModel 
      subDepartmentModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {
   
        subDepartmentRepository.save(subDepartmentModel);
        response.setStatus(true);
        response.setSubDepartmentModel(subDepartmentModel);
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
   * This is a method to update sub department details.
   * @param subDepartmentModel This is a parameter to updateSubDepartment method.
   * @param result This is a parameter to updateSubDepartment method.
   * @return ResponseEntity This returns response of updating sub department.
   */
  @PutMapping("/updateSubDepartment")
  public ResponseEntity<Response> updateSubDepartment(@Valid @RequestBody SubDepartmentModel 
      subDepartmentModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {
   
      try {
        
        if (subDepartmentRepository.existsById(subDepartmentModel.getSubDepartmentId())) {
          subDepartmentRepository.save(subDepartmentModel); 
          response.setStatus(true);
          response.setSubDepartmentModel(subDepartmentModel);
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
   * This is a method to delete sub department detail by id.
   * @param subDepartmentId This is a parameter to deleteSubDepartment method.
   * @return ResponseEntity This returns response of deleting sub department by id.
   */
  @DeleteMapping("/deleteSubDepartment/{subDepartmentId}")
  public ResponseEntity<Response> deleteSubDepartment(@PathVariable("subDepartemntId") 
        String subDepartmentId) {

    Response response = new Response();
    SubDepartmentModel subDepartmentModel = subDepartmentRepository.findById(subDepartmentId).get();
    if (subDepartmentModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Employee Sub Department with id:" 
            + subDepartmentId + "not found");
    }
    subDepartmentRepository.delete(subDepartmentModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response,HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all sub department details. 
   * @return ResponseEntity This returns response of fetching sub department model list
   */
  @GetMapping("/getAllSubDepartment")
  public ResponseEntity<List<SubDepartmentModel>> getAllSubDepartment() {
    
    List<SubDepartmentModel> list = subDepartmentRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<SubDepartmentModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<SubDepartmentModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch sub department detail by id.
   * @param subDepartmentId This is a parameter to getBySubDepartmentId method
   * @return ResponseEntity This returns response of fetching sub department by id
   */
  @GetMapping("/getBySubDepartmentId/{subDepartmentId}")
  public ResponseEntity<SubDepartmentModel> getBySubDepartmentId(@PathVariable("subDepartmentId") 
        String subDepartmentId) {

    SubDepartmentModel subDepartmentModel = subDepartmentRepository.findById(subDepartmentId).get();
    if (subDepartmentModel == null) {
      throw new ResourceNotFoundException("Employee Sub Department with Id:" + subDepartmentId 
          + "not found");
    }
    return new ResponseEntity<SubDepartmentModel>(subDepartmentModel,HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch sub department detail by department id.
   * @param departmentId This is a parameter to getBySbDepartmentId method
   * @return ResponseEntity This returns response of fetching sub department by department id.
   */
  @GetMapping("/getBySbDepartmentId/{departmentId}")
  public ResponseEntity<SubDepartmentModel> getBySbDepartmentId(@PathVariable("departmentId") 
        String departmentId) {

    SubDepartmentModel sbDepartmentModel = subDepartmentRepository.findByDepartmentId(departmentId);
    if (sbDepartmentModel == null) {
      throw new ResourceNotFoundException("Employee Sub Department with department id:" 
        + departmentId + "not found");
    }
    return new ResponseEntity<SubDepartmentModel>(sbDepartmentModel,HttpStatus.OK);
  }
}
