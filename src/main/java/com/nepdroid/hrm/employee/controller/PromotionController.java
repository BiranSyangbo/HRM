package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.PromotionModel;
import com.nepdroid.hrm.employee.repository.PromotionRepository;
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
* simply performs CRUD operations for Employee's Promotion Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class PromotionController {

  @Autowired
  PromotionRepository promotionRepository;

  /**
   * This is a method to register promotion details
   * upon request.
   * @param promotionModel This is a parameter to registerPromotion method.
   * @param result This is a parameter to registerPromotion method.
   * @return ResponseEntity This returns response of registering promotion model  
   */
  @PostMapping("/registerPromotion")
  public ResponseEntity<Response> registerPromotion(@Valid @RequestBody PromotionModel 
        promotionModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
    
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {

        promotionRepository.save(promotionModel);
        response.setStatus(true);
        response.setPromotionModel(promotionModel);

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
   * This is a method to update promotion details
   * upon request.
   * @param promotionModel This is a parameter to updatePromotion method.
   * @param result This is a parameter to updatePromotion method.
   * @return ResponseEntity This returns response of updating promotion. 
   */
  @PutMapping("/updatePromotion")
  public ResponseEntity<Response> updatePromotion(@Valid @RequestBody PromotionModel 
        promotionModel, Errors result) {

    Response response = new Response();
    if (result.hasErrors()) {
    
      Map<String, String> errors = result.getFieldErrors().stream()
          .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

      response.setStatus(false);
      response.setErrorMessages(errors);
      return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

    } else {

      try {
        if (promotionRepository.existsById(promotionModel.getPromotionId())) {
          promotionRepository.save(promotionModel);
          response.setStatus(true);
          response.setPromotionModel(promotionModel);
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
   * This is a method to delete promotion detail based on id.
   * @param promotionId This is a parameter to deletePromotion method.
   * @return ResponseEntity This returns response of deleting promotion.
   */
  @DeleteMapping("/deletePromotion/{promotionId}")
  public ResponseEntity<Response> deletePromotion(@PathVariable("promotionId") String promotionId) {

    PromotionModel promotionModel = promotionRepository.findById(promotionId).get();
    Response response = new Response();
    if (promotionModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Promotion detail with id:" 
          + promotionId + "not found");
    } 
    promotionRepository.delete(promotionModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }
  
  /**
   * This is a method to fetch all promotion details. 
   * @return ResponseEntity This returns response of fetching promotion model list
   */
  @GetMapping("/getAllPromotions")
  public ResponseEntity<List<PromotionModel>> getAllPromotions() {

    List<PromotionModel> list = promotionRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<PromotionModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<PromotionModel>>(list, HttpStatus.OK);
  }

  /**
   *  This is a method to fetch promotion detail by id.
   * @param promotionId This is a parameter to getByPromotionId method.
   * @return ResponseEntity This returns response of fetching promotion model. 
   */
  @GetMapping("/getByPromotionId/{promotionId}")
  public ResponseEntity<PromotionModel> getByPromotionId(@PathVariable("promotionId") 
      String promotionId) {

    PromotionModel promotionModel = promotionRepository.findById(promotionId).get();
    if (promotionModel == null) {
      throw new ResourceNotFoundException("Promotion Detail with Id:" + promotionId + "not found");
    }
    return new ResponseEntity<PromotionModel>(promotionModel, HttpStatus.OK);
  }

}
