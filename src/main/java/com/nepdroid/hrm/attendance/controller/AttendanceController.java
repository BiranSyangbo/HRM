package com.nepdroid.hrm.attendance.controller;

import com.nepdroid.hrm.attendance.model.AttendanceModel;
import com.nepdroid.hrm.attendance.repository.AttendanceRepository;
import com.nepdroid.hrm.attendance.service.AttendanceService;
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
* simply performs CRUD operations for Employee's Attendance Model.
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class AttendanceController {

  @Autowired
  private AttendanceRepository attendanceRepository;
  
  @Autowired
  private AttendanceService attendanceService;
  
  /**
   * This is a method to register attendance details
   * upon request.
   * @param attendanceModel This is a parameter to registerAttendance method.
   * @param result This is a parameter to registerAttendance method.
   * @return ResponseEntity This returns response of registering attendance. 
   */
  @PostMapping("/registerAttendance")
  public ResponseEntity<Response> registerAttendance(@Valid @RequestBody AttendanceModel 
      attendanceModel, Errors result) {
    
    Response response = new Response();
    
    if (result.hasErrors()) {
      //Get error message
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {

        attendanceService.registerAttendance(attendanceModel);
        response.setStatus(true);
        response.setAttendanceModel(attendanceModel);

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
   * This is a method to update attendance details
   * upon request.
   * @param attendanceModel This is a parameter to updateAttendance method.
   * @param result This is a parameter to updateAttendance method.
   * @return ResponseEntity This returns response of updating attendance. 
   */ 
  @PutMapping("/updateAttendance")
  public ResponseEntity<Response> updateAttendance(@RequestBody @Valid AttendanceModel 
      attendanceModel, Errors result) {

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
        attendanceService.updateAttendance(attendanceModel);
        response.setStatus(true);
        response.setAttendanceModel(attendanceModel);  

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
   * This is a method to delete attendance detail by id
   * upon request.
   * @param attendanceId This is a parameter to deleteAttendance method.
   * @return ResponseEntity This returns response of deleting attendance.
   */
  @DeleteMapping("/deleteAttendance/{attendanceId}")
  public ResponseEntity<Response> deleteAttendance(@PathVariable("attendanceId") 
      String attendanceId) {
    
    Response response = new Response();
    AttendanceModel attendanceModel = attendanceRepository.findById(attendanceId).get();
    if (attendanceModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Attendance with id:" 
                                          + attendanceId + "not found");
    }
    attendanceRepository.delete(attendanceModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  
  }
  
  /**
  * This is a method to get all attendance details
  * upon request.
  * @return ResponseEntity This returns response of attendance model list
  */
  @GetMapping(value = "/getAllAttendance")
  public ResponseEntity<List<AttendanceModel>> getAllAttendance() {
    
    List<AttendanceModel> list = attendanceRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<AttendanceModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<AttendanceModel>>(list, HttpStatus.OK);
  }

  /**
   * This is a method to fetch attendance detail by id.
   * @param attendanceId This is a parameter to getByAttendanceId method.
   * @return ResponseEntity This returns response of fetching attendance via id.
   */
  @GetMapping("/getByAttendanceId/{attendanceId}")
  public ResponseEntity<AttendanceModel> getByAttendanceId(@PathVariable("attendanceId") 
      String attendanceId) {
    
    AttendanceModel attendanceModel = attendanceRepository.findById(attendanceId).get();
    if (attendanceModel == null) {
      throw new ResourceNotFoundException("Attendance with id:" + attendanceId + "not found");
    }
    return new ResponseEntity<AttendanceModel>(attendanceModel, HttpStatus.OK);
  }
  
}
