package com.nepdroid.hrm.employee.controller;

import com.nepdroid.hrm.employee.model.AcademicModel;
import com.nepdroid.hrm.employee.repository.AcademicRepository;
import com.nepdroid.hrm.entity.Response;
import com.nepdroid.hrm.exception.ResourceNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
* This class program implements an application that
* simply performs CRUD operations for Employee's Academic Model. 
*
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@RestController
public class AcademicController {

  @Autowired
  AcademicRepository academicRepository;

  // Save the uploaded file to this folder
  private static String UPLOADED_FOLDER = "E://HRM_files//";

/*  @PostMapping("/registerAcademic")
  public ResponseEntity<Response> addAcademic(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes, @Valid @RequestBody AcademicModel academicModel, Errors result) {
	
		Response response = new Response();
		
		try {
			if (result.hasErrors()) {
				// Get error message
				Map<String, String> errors = result.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				response.setStatus(false);
				response.setErrorMessages(errors);
			} else {

				try {
					// Get the file and save it somewhere
					byte[] bytes = file.getBytes();
					Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
					Files.write(path, bytes);
					
					
					
					System.out.println(file.getOriginalFilename());

					redirectAttributes.addFlashAttribute("message",
							"You successfully uploaded '" + file.getOriginalFilename() + "'");
									
					academicService.addAcademic(academicModel);
					response.setStatus(true);
					response.setAcademicModel(academicModel);

				} catch (Exception ex) {
					System.out.println(ex.toString());
					Map<String, String> errors = new HashMap<>();
					errors.put("Error message", ex.toString());
					response.setErrorMessages(errors);
				}
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAcademic", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Response> updateAcademic(@Valid @RequestBody AcademicModel academicModel, Errors result) {
		Response response = new Response();

		try {
			if (result.hasErrors()) {
				// Get error message
				Map<String, String> errors = result.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				response.setStatus(false);
				response.setErrorMessages(errors);
			} else {

				try {
					academicService.updateAcademic(academicModel);
					response.setStatus(true);
					response.setAcademicModel(academicModel);

				} catch (Exception ex) {
					System.out.println(ex.toString());
					Map<String, String> errors = new HashMap<>();
					errors.put("Error message", ex.toString());
					response.setErrorMessages(errors);
				}
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}*/

  /**
   * This is a method to delete academic detail based on id.
   * @param academicId This is a parameter to deleteAcademic method.
   * @return ResponseEntity This returns response of deleting Academic by id.
   */
  @DeleteMapping("/deleteAcademic/{academicId}")
  public ResponseEntity<Response> deleteAcademic(@PathVariable("academicId") String academicId) {

    Response response = new Response();
    AcademicModel academicModel = academicRepository.findById(academicId).get();
    if (academicModel == null) {
      throw new ResourceNotFoundException("Unable to delete. Employee Academic with id:" 
          + academicId + "not found");
    }
    academicRepository.delete(academicModel);
    response.setStatus(true);
    return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
  }

  /**
   * This is a method to fetch all academic details. 
   * @return ResponseEntity This returns response of fetching all academic list
   */
  @GetMapping("/getAllAcademic")
  public ResponseEntity<List<AcademicModel>> getAllAcademic() {

    List<AcademicModel> list = academicRepository.findAll();
    if (list.isEmpty()) {
      return new ResponseEntity<List<AcademicModel>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<AcademicModel>>(list, HttpStatus.OK);
  }

  /**
   *  This is a method to fetch academic detail by id.
   * @param academicId This is a parameter to getByAcademicId method.
   * @return ResponseEntity This returns response of fetching academic by id. 
   */ 
  @GetMapping("/getByAcademicId/{academicId}")
  public ResponseEntity<AcademicModel> getByAcademicId(@PathVariable("academicId") 
        String academicId) {

    AcademicModel academicModel = academicRepository.findById(academicId).get();
    if (academicModel == null) {
      throw new ResourceNotFoundException("Employee Academic with id:" + academicId + "not found");
    }
    return new ResponseEntity<AcademicModel>(academicModel, HttpStatus.OK);
  }

}
