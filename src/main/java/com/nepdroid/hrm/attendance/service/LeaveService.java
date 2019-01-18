package com.nepdroid.hrm.attendance.service;

import com.nepdroid.hrm.attendance.model.LeaveModel;
import com.nepdroid.hrm.attendance.repository.LeaveRepository;
import com.nepdroid.hrm.entity.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* This class program implements an application that
* simply handles business logic to manage Employee's leave.
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/

@Service
public class LeaveService {

  @Autowired
  private LeaveRepository leaveRepository;
  
  /**
   * This is a method to handle employee leave.
   * @param leaveModel This is a parameter to registerLeave method.
   * @return Response This returns response of handling leave. 
   */
  public Response registerLeave(LeaveModel leaveModel) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date leaveStart = dateFormat.parse(leaveModel.getLeaveStartDate());
      Date leaveEnd = dateFormat.parse(leaveModel.getLeaveEndDate());

      long leaveCount = (leaveEnd.getTime() - leaveStart.getTime()) / (1000 * 86400); 
      //no unit while getting leave_count as ms cancel ms
      leaveModel.setLeaveDaysTotal(String.valueOf(leaveCount + 1));

    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
    
    leaveRepository.save(leaveModel);
    Response response = new Response();
    return response;
  }
  
  /**
   * This is a method to update employee leave.
   * @param leaveModel This is a parameter to updateLeave method.
   * @return Response This returns response of updating leave. 
   */
  public Response updateLeave(LeaveModel leaveModel) {

    if (leaveRepository.existsById(leaveModel.getLeaveId())) {
      registerLeave(leaveModel);
    }
    Response response = new Response();
    return response;  
  }
}
