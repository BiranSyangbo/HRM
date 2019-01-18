package com.nepdroid.hrm.attendance.controller;

import com.nepdroid.hrm.attendance.model.CompanyCalenderModel;
import com.nepdroid.hrm.attendance.repository.CompanyCalenderRepository;
import com.nepdroid.hrm.attendance.service.CompanyCalenderService;
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
* simply performs CRUD operations for Company Calender Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class CompanyCalenderController {

  @Autowired
  CompanyCalenderRepository companyCalenderRepository;
  
  @Autowired
  private CompanyCalenderService companyCalenderService;

  /**
   * This is a method to register  company calender details
   * upon request.
   * @param companyCalenderModel This is a parameter to registerCompanyCalender method.
   * @param result This is a parameter to registerCompanyCalender method.
   * @return ResponseEntity This returns response of registering Company Calender.  
   */
  @PostMapping("/registerCompanyCalender")
  public ResponseEntity<Response> registerCompanyCalender(@Valid @RequestBody CompanyCalenderModel 
        companyCalenderModel, Errors result) {

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

        companyCalenderService.registerCompanyCalender(companyCalenderModel);
        response.setStatus(true);
        response.setCompanyCalenderModel(companyCalenderModel);

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
   * This is a method to update company calender details
   * upon request.
   * @param companyCalenderModel This is a parameter to updateCompanyCalender method.
   * @param result This is a parameter to updateCompanyCalender method.
   * @return ResponseEntity This returns response of updating Company calender. 
   */
  @PutMapping("/updateCompanyCalender")
  public ResponseEntity<Response> updateCompanyCalender(@Valid @RequestBody CompanyCalenderModel 
        companyCalenderModel, Errors result) {

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
          
        companyCalenderService.updateCompanyCalender(companyCalenderModel);
        response.setStatus(true);
        response.setCompanyCalenderModel(companyCalenderModel);   
      
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
   * This is a method to delete company calender detail based on id.
   * @param companyCalenderId This is a parameter to deletecompanyCalender method.
   * @return ResponseEntity This returns response of deleting company calender.
   */
  @DeleteMapping("/deleteCompanyCalender/{companyCalenderId}")
  public ResponseEntity<Response> deleteCompanyCalender(@PathVariable("companyCalenderId") 
        String companyCalenderId) {

    CompanyCalenderModel calenderModel = companyCalenderRepository.findById(companyCalenderId)
         .get();
    Response response = new Response();
    if (calenderModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Company Calender with id:" 
          + companyCalenderId + "not found");
    }
    companyCalenderRepository.delete(calenderModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }


  /**
   * This is a method to fetch all company calender details. 
   * @return ResponseEntity This returns response of fetching company calender.
   */
  @GetMapping("/getAllCompanyCalender")
  public ResponseEntity<List<CompanyCalenderModel>> getAllCompanyCalender() {

    List<CompanyCalenderModel> list = companyCalenderRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<CompanyCalenderModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<CompanyCalenderModel>>(list, HttpStatus.OK);
  }

  /**
   *  This is a method to fetch company calender detail by id.
   * @param companyCalenderId This is a parameter to getByCompanyCalenderId method.
   * @return ResponseEntity This returns response of fetching company calender.
   */  
  @GetMapping("/getByCompanyCalenderId/{companyCalenderId}")
  public ResponseEntity<CompanyCalenderModel> getByCompanyCalenderId(
      @PathVariable("companyCalenderId") String companyCalenderId) {

    CompanyCalenderModel calenderModel = companyCalenderRepository.findById(companyCalenderId)
         .get();
    if (calenderModel == null) {
      throw new ResourceNotFoundException("Company Calender with id:" + companyCalenderId 
            + "not found");
    }
    return new ResponseEntity<CompanyCalenderModel>(calenderModel, HttpStatus.OK);
  }

}
