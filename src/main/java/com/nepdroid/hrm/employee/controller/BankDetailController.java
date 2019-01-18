package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.BankDetailModel;
import com.nepdroid.hrm.employee.repository.BankDetailRepository;
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
* simply performs CRUD operations for Bank Detail Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class BankDetailController {

  @Autowired
  BankDetailRepository bankDetailRepository;

  /**
   * This is a method to register employee's bank details
   * upon request.
   * @param bankDetailModel This is a parameter to registerBankDetail method.
   * @param result This is a parameter to registerBankDetail method.
   * @return ResponseEntity This returns response of registering bank model  
   */
  @PostMapping("/registerBankDetail")
  public ResponseEntity<Response> registerBankDetail(@Valid @RequestBody BankDetailModel 
        bankDetailModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
    } else {
      try {
        bankDetailRepository.save(bankDetailModel);
        response.setStatus(true);
        response.setBankDetailModel(bankDetailModel);

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
   * This is a method to update employee's bank details
   * upon request.
   * @param bankDetailModel This is a parameter to updateBankDetail method.
   * @param result This is a parameter to updateBankDetail method.
   * @return ResponseEntity This returns response of updating Bank Detail. 
   */ 
  @PutMapping("/updateBankDetail")
  public ResponseEntity<Response> updateBankDetail(@Valid @RequestBody BankDetailModel 
      bankDetailModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
      Map<String, String> errors = result.getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
   
    } else {

      try {
        if (bankDetailRepository.existsById(bankDetailModel.getBankId())) {
          bankDetailRepository.save(bankDetailModel);
          response.setStatus(true);
          response.setBankDetailModel(bankDetailModel);
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
   * This is a method to delete bank detail based on id.
   * @param bankId This is a parameter to deleteBankDetail method.
   * @return ResponseEntity This returns response of deleting bank.
   */
  @DeleteMapping("/deleteBankDetail/{bankId}")
  public ResponseEntity<Response> deleteBankDetail(@PathVariable("bankId") String bankId) {
       
    Response response = new Response();
    BankDetailModel bankDetailModel = bankDetailRepository.findById(bankId).get();
    if (bankDetailModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Bank detail with id:" 
        + bankId + "not found");
    } 
    bankDetailRepository.delete(bankDetailModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all employee's bank details. 
   * @return ResponseEntity This returns response of fetching bank model list
   */
  @GetMapping("/getAllBankDetail")
  public ResponseEntity<List<BankDetailModel>> getAllBankDetail() {

    List<BankDetailModel> list = bankDetailRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<BankDetailModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<BankDetailModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch bank detail by id.
   * @param bankId This is a parameter to getByBankId method.
   * @return ResponseEntity This returns response of fetching bank model 
   */
  @GetMapping("/getByBankId/{bankId}")
  public ResponseEntity<BankDetailModel> getByBankId(@PathVariable("bankId") String bankId) {

    BankDetailModel bankDetailModel = bankDetailRepository.findById(bankId).get();
    if (bankDetailModel == null) {
      throw new ResourceNotFoundException("Bank Detail with Id:" + bankId + "not found");
    }
    return new ResponseEntity<BankDetailModel>(bankDetailModel, HttpStatus.OK);
  }
}
