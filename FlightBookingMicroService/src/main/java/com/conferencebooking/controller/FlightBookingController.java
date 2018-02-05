package com.conferencebooking.controller;


import com.conferencebooking.model.BookingDetail;
import com.conferencebooking.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightBookingController {

   @Autowired
   FlightBookingService flightBookingService;


  @GetMapping("/booking/{id}/details")
  public Object getBookingDetail(@PathVariable(name = "id") String userID) {
    return flightBookingService.getBookingDetail(userID);
  }

}
