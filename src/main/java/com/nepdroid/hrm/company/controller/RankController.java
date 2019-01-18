package com.nepdroid.hrm.company.controller;

import com.nepdroid.hrm.company.model.RankModel;
import com.nepdroid.hrm.company.repository.RankRepository;
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
* simply performs CRUD operations for Employee's Rank Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class RankController {

  @Autowired
  RankRepository rankRepository;

  /**
   * This is a method to register rank details
   * upon request.
   * @param rankModel This is a parameter to registerRank method.
   * @param result This is a parameter to registerRank method.
   * @return ResponseEntity This returns response of registering rank model  
   */
  @PostMapping("/registerRank")
  public ResponseEntity<Response> registerRank(@Valid @RequestBody RankModel rankModel, 
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

        rankRepository.save(rankModel);
        response.setStatus(true);
        response.setRankModel(rankModel);

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
   * This is a method to update rank details
   * upon request.
   * @param rankModel This is a parameter to updateRank method.
   * @param result This is a parameter to updateRank method.
   * @return ResponseEntity This returns response of updating rank model  
   */
  @PutMapping("/updateRank")
  public ResponseEntity<Response> updateRank(@Valid @RequestBody RankModel rankModel, 
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
        if (rankRepository.existsById(rankModel.getRankId())) {
          rankRepository.save(rankModel);
          response.setStatus(true);
          response.setRankModel(rankModel); 
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
   * This is a method to delete rank detail based on id.
   * @param rankId This is a parameter to deleteRank method.
   * @return ResponseEntity This returns response of deleting rank.
   */
  @DeleteMapping("/deleteRole/{rank_id}")
  public ResponseEntity<Response> deleteRank(@PathVariable("rankId") String rankId) {

    Response response = new Response();
    RankModel rankModel = rankRepository.findById(rankId).get();
    if (rankModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Rank detail with id:" 
          + rankId + "not found");
    }
    rankRepository.delete(rankModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }
  
  /**
   * This is a method to fetch all rank details. 
   * @return ResponseEntity This returns response of fetching rank model list
   */
  @GetMapping("/getAllRanks")
  public ResponseEntity<List<RankModel>> getAllRanks() {

    List<RankModel> list = rankRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<RankModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<RankModel>>(list, HttpStatus.OK);
  }
  
  /**
   *  This is a method to fetch rank detail by id.
   * @param rankId This is a parameter to getByRankId method.
   * @return ResponseEntity This returns response of fetching rank model. 
   */
  @GetMapping("/getByRankId/{rankId}")
  public ResponseEntity<RankModel> getByRankId(@PathVariable("rankId") String rankId) {

    RankModel rankModel = rankRepository.findById(rankId).get();
    if (rankModel == null) {
      throw new ResourceNotFoundException("Rank Detail with Id:" + rankId + "not found");
    }
    return new ResponseEntity<RankModel>(rankModel, HttpStatus.OK);
  }

}
