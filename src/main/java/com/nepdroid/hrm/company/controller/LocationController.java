package com.nepdroid.hrm.company.controller;

import com.nepdroid.hrm.company.model.LocationModel;
import com.nepdroid.hrm.company.repository.LocationRepository;
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
* simply performs CRUD operations for Location Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/

@RestController
public class LocationController {

  @Autowired
  private LocationRepository locationRepository;

  /**
   * This is a method to register branch location details
   * upon request.
   * @param locationModel This is a parameter to registerLocation method.
   * @param result This is a parameter to registerLocation method.
   * @return ResponseEntity This returns response of registering branch location model. 
   */
  @PostMapping("/registerLocation")
  public ResponseEntity<Response> registerLocation(@Valid @RequestBody LocationModel locationModel, 
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

        locationRepository.save(locationModel);
        response.setStatus(true);
        response.setLocationModel(locationModel);

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
   * This is a method to update branch location details
   * upon request.
   * @param locationModel This is a parameter to updateLocation method.
   * @param result This is a parameter to updateLocation method.
   * @return ResponseEntity This returns response of updating branch location.
   */  
  @PutMapping("/updateLocation")
  public ResponseEntity<Response> updateLocation(@Valid @RequestBody LocationModel locationModel, 
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
        if (locationRepository.existsById(locationModel.getLocationId())) {
          locationRepository.save(locationModel);
          response.setStatus(true);
          response.setLocationModel(locationModel);
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
   * This is a method to delete location detail based on location id.
   * @param locationId This is a parameter to deleteLocation method.
   * @return ResponseEntity This returns response of deleting location.
   */
  @DeleteMapping("/deleteLocation/{locationId}")
  public ResponseEntity<Response> deleteLocation(@PathVariable("locationId") 
        String locationId) {
    
    Response response = new Response();  
    LocationModel locationModel = locationRepository.findById(locationId).get();
    if (locationModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Location with id:" + locationId 
          + "not found");
    }
    locationRepository.delete(locationModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response,HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all location details. 
   * @return ResponseEntity This returns response of fetching location model list
   */
  @GetMapping("/getAllLocation")
  public ResponseEntity<List<LocationModel>> getAllLocation() {
 
    List<LocationModel> list = locationRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<LocationModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<LocationModel>>(list, HttpStatus.OK);
  }

  /**
   *  This is a method to fetch location detail by id.
   * @param locationId This is a parameter to getByLocationId method
   * @return ResponseEntity This returns response of fetching location model
   */
  @GetMapping("/getByLocationId/{locationId}")
  public ResponseEntity<LocationModel> getByLocationId(@PathVariable("locationId") 
      String locationId) {
    
    LocationModel locationModel = locationRepository.findById(locationId).get();
    if (locationModel  == null) {
      throw new ResourceNotFoundException("Location with id:" + locationId + "not found");
    }
    return new ResponseEntity<LocationModel>(locationModel,HttpStatus.OK);
  }
  
  
  /**
   *  This is a method to fetch location detail by branch id.
   * @param branchId This is a parameter to getByLocationBranchId method
   * @return ResponseEntity This returns response of fetching location detail by branch id.
   */
  @GetMapping("/getByLocationBranchId/{branchId}")
  public ResponseEntity<LocationModel> getByLocationBranchId(@PathVariable("branchId") 
      String branchId) {
    
    LocationModel locationModel = locationRepository.findByBranchId(branchId);
    if (locationModel  == null) {
      throw new ResourceNotFoundException("Location with branch id:" + branchId + "not found");
    }
    return new ResponseEntity<LocationModel>(locationModel,HttpStatus.OK);
  }
}


/* LocationModel locationModel2 = locationRepository.findById(locationModel
.getLocation_id()).get();
locationModel2.setCity(locationModel.getCity());
locationModel2.setCountry(locationModel.getCountry());
locationModel2.setDelete_flag(locationModel.getDelete_flag());
locationModel2.setRegion(locationModel.getRegion());
locationModel2.setState_province(locationModel.getState_province());
locationModel2.setStreet_address(locationModel.getStreet_address());
locationRepository.save(locationModel2);
response.setStatus(true);
response.setLocationModel(locationModel2); */