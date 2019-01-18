package com.nepdroid.hrm.company.controller;

import com.nepdroid.hrm.company.model.BranchModel;
import com.nepdroid.hrm.company.repository.BranchRepository;
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
* simply performs CRUD operations for Branch Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/

@RestController
public class BranchController {

  @Autowired
  BranchRepository branchRepository;

  /**
   * This is a method to insert branch details
   * upon request.
   * @param branchModel This is a parameter to registerBranch method.
   * @param result This is a parameter to registerBranch method.
   * @return ResponseEntity This returns response of registering branch model  
   */
  @PostMapping("/registerBranch")
  public ResponseEntity<Response> registerBranch(@Valid @RequestBody BranchModel branchModel, 
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

        branchRepository.save(branchModel);
        response.setStatus(true);
        response.setBranchModel(branchModel);

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
   * This is a method to update branch details
   * upon request.
   * @param branchModel This is a parameter to updateBranch method.
   * @param result This is a parameter to updateBranch method.
   * @return ResponseEntity This returns response of updating branch 
   */  
  @PutMapping("/updateBranch")
  public ResponseEntity<Response> updateBranch(@Valid @RequestBody BranchModel branchModel, 
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
        if (branchRepository.existsById(branchModel.getBranchId())) {
          branchRepository.save(branchModel); 
          response.setStatus(true);
          response.setBranchModel(branchModel);
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
   * This is a method to delete branch detail based on id.
   * @param branchId This is a parameter to deleteBranch method.
   * @return ResponseEntity This returns response of deleting branch.
   */
  @DeleteMapping("/deleteBranch/{branchId}")
  public ResponseEntity<Response> deleteBranch(@PathVariable("branchId") 
        String branchId) {
    
    Response response = new Response();  
    BranchModel branchModel = branchRepository.findById(branchId).get();
    if (branchModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Branch with id:" + branchId 
          + "not found");
    }
    branchRepository.delete(branchModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response,HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all branch details. 
   * @return ResponseEntity This returns response of fetching branch model list
   */
  @GetMapping("/getAllBranch")
  public ResponseEntity<List<BranchModel>> getAllBranch() {
 
    List<BranchModel> list = branchRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<BranchModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<BranchModel>>(list, HttpStatus.OK);
  }

  /**
   *  This is a method to fetch branch detail by id.
   * @param branchId This is a parameter to getByBranchId method
   * @return ResponseEntity This returns response of fetching branch model 
   */
  @GetMapping("/getByBranchId/{branchId}")
  public ResponseEntity<BranchModel> getByBranchId(@PathVariable("branchId") 
      String branchId) {
    
    BranchModel branchModel = branchRepository.findById(branchId).get();
    if (branchModel  == null) {
      throw new ResourceNotFoundException("Branch with id:" + branchId + "not found");
    }
    return new ResponseEntity<BranchModel>(branchModel,HttpStatus.OK);
  }
  
}

