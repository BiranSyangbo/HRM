package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.ContactModel;
import com.nepdroid.hrm.employee.repository.ContactRepository;
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


/**
* This class program implements an application that
* simply performs CRUD operations for Employee's Contact Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/

public class ContactController {

  @Autowired
  ContactRepository contactRepository;

  /**
   * This is a method to register contact details
   * upon request.
   * @param contactModel This is a parameter to registerContact method.
   * @param result This is a parameter to registerContact method.
   * @return ResponseEntity This returns response of registering contact model  
   */
  @PostMapping("/registerContact")
  public ResponseEntity<Response> registerContact(@Valid @RequestBody ContactModel contactModel, 
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

        contactRepository.save(contactModel);
        response.setStatus(true);
        response.setContactModel(contactModel);

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
   * This is a method to update contact details
   * upon request.
   * @param contactModel This is a parameter to updateContact method.
   * @param result This is a parameter to updateContact method.
   * @return ResponseEntity This returns response of updating contact. 
   */
  @PutMapping("/updateContact")
  public ResponseEntity<Response> updateContact(@Valid @RequestBody ContactModel contactModel,
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
    
        if (contactRepository.existsById(contactModel.getContactId())) {
          contactRepository.save(contactModel);
          response.setStatus(true);
          response.setContactModel(contactModel);
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
   * This is a method to delete contact detail based on id.
   * @param contactId This is a parameter to deleteContact method.
   * @return ResponseEntity This returns response of deleting contact.
   */
  @DeleteMapping("/deleteContact/{contactId}")
  public ResponseEntity<Response> deleteContact(@PathVariable("contactId") String contactId) {

    ContactModel contactModel = contactRepository.findById(contactId).get();
    Response response = new Response();
    if (contactModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Employee Contact with id:" 
          + contactId + "not found");
    } 
    contactRepository.delete(contactModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all contact details. 
   * @return ResponseEntity This returns response of fetching contact model list
   */
  @GetMapping("/getAllContact")
  public ResponseEntity<List<ContactModel>> getAllContact() {

    List<ContactModel> list = contactRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<ContactModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<ContactModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch contact detail by id.
   * @param contactId This is a parameter to getByContactId method.
   * @return ResponseEntity This returns response of fetching contact model. 
   */  
  @GetMapping("/getByContactId/{contactId}")
  public ResponseEntity<ContactModel> getByContactId(@PathVariable("contactId") String contactId) {
    
    ContactModel contactModel = contactRepository.findById(contactId).get();
    if (contactModel == null) {
      throw new ResourceNotFoundException("Employee Contact with Id:" + contactId + "not found");
    }
    return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
  }
}
