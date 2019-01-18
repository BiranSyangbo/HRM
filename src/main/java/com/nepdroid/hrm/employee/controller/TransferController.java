package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.TransferModel;
import com.nepdroid.hrm.employee.repository.TransferRepository;
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
* simply performs CRUD operations for Employee's Transfer Model.
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class TransferController {

  @Autowired
  TransferRepository transferRepository;
  
  /**
   * This is a method to register transfer details upon request.
   * @param transferModel This is a parameter to registerTransfer method.
   * @param result This is a parameter to registerTransfer method.
   * @return ResponseEntity This returns response of registering transfer model.
   */
  @PostMapping("/registerTransfer")
  public ResponseEntity<Response> registerTransfer(@Valid @RequestBody TransferModel 
      transferModel, Errors result) {
    
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

        transferRepository.save(transferModel);
        response.setStatus(true);
        response.setTransferModel(transferModel);

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
   * This is a method to update transfer details upon request.
   * @param transferModel This is a parameter to updateTransfer method.
   * @param result This is a parameter to updateTransfer method.
   * @return ResponseEntity This returns response of updating transfer model. 
   */  
  @PutMapping("/updateTransfer")
  public ResponseEntity<Response> updateTransfer(@RequestBody @Valid TransferModel 
      transferModel, Errors result) {

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
        if (transferRepository.existsById(transferModel.getTransferId())) {
          transferRepository.save(transferModel);
          response.setStatus(true);
          response.setTransferModel(transferModel);
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
   * This is a method to delete transfer detail by id
   * upon request.
   * @param transferId This is a parameter to deleteTransfer method.
   * @return ResponseEntity This returns response of deleting transfer model.
   */
  @DeleteMapping("/deleteTransfer/{transferId}")
  public ResponseEntity<Response> deleteTransfer(@PathVariable("transferId") 
      String transferId) {
    
    Response response = new Response();
    TransferModel transferModel = transferRepository.findById(transferId).get();
    if (transferModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Transfer with id:" 
                                          + transferId + "not found");
    }
    transferRepository.delete(transferModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  
  }
  
  /**
  * This is a method to get all transfer details upon request.
  * @return ResponseEntity This returns response of transfer model list.
  */
  @GetMapping("/getAllTransfer")
  public ResponseEntity<List<TransferModel>> getAllTransfer() {
    
    List<TransferModel> list = transferRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<TransferModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<TransferModel>>(list, HttpStatus.OK);
  }

  /**
   * This is a method to fetch transfer details by id upon request. 
   * @param transferId This is a parameter to getByTransferId method.
   * @return ResponseEntity This returns response of fetching transfer model via id.
   */
  @GetMapping("/getByTransferId/{transferId}")
  public ResponseEntity<TransferModel> getByTransferId(@PathVariable("transferId") 
      String transferId) {
    
    TransferModel transferModel = transferRepository.findById(transferId).get();
    if (transferModel == null) {
      throw new ResourceNotFoundException("Transfer with id:" + transferId + "not found");
    }
    return new ResponseEntity<TransferModel>(transferModel, HttpStatus.OK);
  }
  
}
