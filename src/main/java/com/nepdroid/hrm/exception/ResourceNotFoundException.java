package com.nepdroid.hrm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  
  /**
   * Serial UID version number. 
   */
  private static final long serialVersionUID = -6997815438567553888L;

  public ResourceNotFoundException() {
    super();
  }


  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(String message, Throwable cause) {
    super(message,cause);
  }
}




