package com.conferencebooking.service;


import com.conferencebooking.datasource.FlightBookingDetails;
import com.conferencebooking.model.BookingDetail;
import org.springframework.stereotype.Component;

@Component
public class FlightBookingService {

  public BookingDetail getBookingDetail(String userID){
     return FlightBookingDetails.BOOKING_DETAIL_MAP.get(userID);

  }

}
