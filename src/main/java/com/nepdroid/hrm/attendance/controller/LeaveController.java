package com.nepdroid.hrm.attendance.controller;

import com.nepdroid.hrm.attendance.model.LeaveModel;
import com.nepdroid.hrm.attendance.repository.LeaveRepository;
import com.nepdroid.hrm.attendance.service.LeaveService;
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
* simply performs CRUD operations for Employee's Leave Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class LeaveController {

  @Autowired
  private LeaveRepository leaveRepository;
  
  @Autowired
  private LeaveService leaveService;  

  /**
   * This is a method to register leave details
   * upon request.
   * @param leaveModel This is a parameter to registerLeave method.
   * @param result This is a parameter to registerLeave method.
   * @return ResponseEntity This returns response of registering leave.  
   */
  @PostMapping("/registerLeave")
  public ResponseEntity<Response> registerLeave(@Valid @RequestBody LeaveModel leaveModel, 
       Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
   
      Map<String, String> errors = result.getFieldErrors().stream()
           .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {

        leaveService.registerLeave(leaveModel);
        response.setStatus(true);
        response.setLeaveModel(leaveModel);

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
   * This is a method to update leave details
   * upon request.
   * @param leaveModel This is a parameter to updateLeave method.
   * @param result This is a parameter to updateLeave method.
   * @return ResponseEntity This returns response of updating leave. 
   */
  @PutMapping("/updateLeave")
  public ResponseEntity<Response> updateLeave(@RequestBody @Valid LeaveModel leaveModel, 
      Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {

      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
      
    } else {
   
      try {
        
        leaveService.updateLeave(leaveModel);
        response.setStatus(true);
        response.setLeaveModel(leaveModel);  
      
      } catch (Exception ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("Error message", ex.toString());
        response.setErrorMessages(errors);
        response.setStatus(false);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

      }
      return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
  }

  /**
   * This is a method to delete leave detail based on id.
   * @param leaveId This is a parameter to deleteLeave method.
   * @return ResponseEntity This returns response of deleting leave.
   */
  @DeleteMapping("/deleteLeave/{leaveId}")
  public ResponseEntity<Response> deleteLeave(@PathVariable("leaveId") String leaveId) {

    LeaveModel leaveModel = leaveRepository.findById(leaveId).get();
    Response response = new Response();
    if (leaveModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Leave with id:"
          + leaveId + "not found");
    }
    leaveRepository.delete(leaveModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);

  }

  /**
   * This is a method to fetch all leave details. 
   * @return ResponseEntity This returns response of fetching leave list
   */
  @GetMapping(value = "/getAllLeave")
  public ResponseEntity<List<LeaveModel>> getAllLeave() {

    List<LeaveModel> list = leaveRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<LeaveModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<LeaveModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch leave detail by id.
   * @param leaveId This is a parameter to getByLeaveId method.
   * @return ResponseEntity This returns response of fetching leave by id. 
   */  
  @GetMapping("/getByLeaveId/{leaveId}")
  public ResponseEntity<LeaveModel> getByLeaveId(@PathVariable("leaveId") String leaveId) {

    LeaveModel leaveModel = leaveRepository.findById(leaveId).get();
    if (leaveModel == null) {
      throw new ResourceNotFoundException("Leave with id:" + leaveId + "not found");
    }
    return new ResponseEntity<LeaveModel>(leaveModel, HttpStatus.OK);

  }

}
