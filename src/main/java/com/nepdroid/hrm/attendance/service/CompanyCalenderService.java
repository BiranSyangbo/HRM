package com.nepdroid.hrm.attendance.service;

import com.nepdroid.hrm.attendance.model.CompanyCalenderModel;
import com.nepdroid.hrm.attendance.repository.CompanyCalenderRepository;
import com.nepdroid.hrm.entity.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
* This class program implements an application that
* simply handles business logic to manage Company Calender.
* @author  Bipin Shrestha
* @version 1.0
* @since   2018-11-31 
*/
@Service
public class CompanyCalenderService {

  @Autowired
  private CompanyCalenderRepository calenderRepository;
  
  /**
   * This is a method to register company calender.
   * @param companyCalenderModel This is a parameter to registerCompanyCalender method.
   * @return Response This returns response of registering company calender. 
   */
  public Response registerCompanyCalender(CompanyCalenderModel companyCalenderModel) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date dateFrom = dateFormat.parse(companyCalenderModel.getDateFrom());
      Date dateTo = dateFormat.parse(companyCalenderModel.getDateTo());

      long diff = (dateTo.getTime() - dateFrom.getTime()) / (1000 * 86400);

      // long diff = (Date_from.getTime()-Date_to.getTime())/86400;
      // System.out.println(diff+1);

      companyCalenderModel.setTotalHoliday(String.valueOf(diff + 1));

    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
    
    calenderRepository.save(companyCalenderModel);
    Response response = new Response();
    return response;

  }
  
  /**
   * This is a method to update Company Calender.
   * @param companyCalenderModel This is a parameter to updateCompanyCalender method.
   * @return Response This returns response of updating Company calender. 
   */
  public Response updateCompanyCalender(CompanyCalenderModel companyCalenderModel) {

    if (calenderRepository.existsById(companyCalenderModel.getCompanyCalenderId())) {
      registerCompanyCalender(companyCalenderModel);
    } 
    Response response = new Response();
    return response;  
  }
}
