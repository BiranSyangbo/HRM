package com.nepdroid.hrm.attendance.controller;

import com.nepdroid.hrm.attendance.model.WorkShiftModel;
import com.nepdroid.hrm.attendance.repository.WorkShiftRepository;
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
* simply performs CRUD operations for Company's  WorkShift Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class WorkShiftController {

  @Autowired
  WorkShiftRepository workShiftRepository;

  /**
   * This is a method to register Work shift details
   * upon request.
   * @param workShiftModel This is a parameter to registerWorkShift method.
   * @param result This is a parameter to registerWorkShift method.
   * @return ResponseEntity This returns response of registering work shift  
   */
  @PostMapping("/registerWorkShift")
  public ResponseEntity<Response> registerWorkShift(@Valid @RequestBody 
      WorkShiftModel workShiftModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      // Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {

        workShiftRepository.save(workShiftModel);
        response.setStatus(true);
        response.setWorkShiftModel(workShiftModel);

      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<Response>(response, HttpStatus.CREATED);
    }
  }

  /**
   * This is a method to update workshift details
   * upon request.
   * @param workShiftModel This is a parameter to updateWorkShift method.
   * @param result This is a parameter to  updateWorkShift method.
   * @return ResponseEntity This returns response of updating workshift. 
   */
  @PutMapping("/updateWorkShift")
  public ResponseEntity<Response> updateWorkShift(@RequestBody @Valid 
        WorkShiftModel workShiftModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      // Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {
   
      try {
    
        if (workShiftRepository.existsById(workShiftModel.getWorkshiftId())) {
          workShiftRepository.save(workShiftModel);
          response.setStatus(true);
          response.setWorkShiftModel(workShiftModel);
        } else {
          throw new Exception();
        }

      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setErrorMessages(errors);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
  }

  /**
   * This is a method to delete workshift detail based on id.
   * @param workShiftId This is a parameter to deleteWorkShift method.
   * @return ResponseEntity This returns response of deleting workshift by id.
   */
  @DeleteMapping("/deleteWorkShift/{workshiftId}")
  public ResponseEntity<Response> deleteWorkShift(@PathVariable("workShiftId") String workShiftId) {

    Response response = new Response();
    WorkShiftModel workShiftModel = workShiftRepository.findById(workShiftId).get();
    if (workShiftModel == null) {
      throw new ResourceNotFoundException("Unable to delete. WorkShift with id:" 
         + workShiftId + "not found");
    }
    workShiftRepository.delete(workShiftModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all work shift details. 
   * @return ResponseEntity This returns response of fetching work shift list
   */
  @GetMapping("/getAllWorkShift")
  public ResponseEntity<List<WorkShiftModel>> getAllWorkShift() {

    List<WorkShiftModel> list = workShiftRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<WorkShiftModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<WorkShiftModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch work shift detail by id.
   * @param workShiftId This is a parameter to getByWorkShiftId method.
   * @return ResponseEntity This returns response of fetching work shift by id. 
   */ 
  @GetMapping("/getByWorkShiftId/{workShiftId}")
  public ResponseEntity<WorkShiftModel> getById(@PathVariable("workShiftId") String workShiftId) {

    WorkShiftModel workShiftModel = workShiftRepository.findById(workShiftId).get();
    if (workShiftModel == null) {
      throw new ResourceNotFoundException("WorkShift with id:" + workShiftId + "not found");
    }
    return new ResponseEntity<WorkShiftModel>(workShiftModel, HttpStatus.OK);
  }

}
