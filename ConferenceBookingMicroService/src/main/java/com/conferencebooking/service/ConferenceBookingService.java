package com.conferencebooking.service;

import com.conferencebooking.datasource.ConferenceBookingDetails;
import com.conferencebooking.model.BookingDetail;
import org.springframework.stereotype.Component;

@Component
public class ConferenceBookingService {

  public BookingDetail getBookingDetail(String userID){
    return ConferenceBookingDetails.BOOKING_DETAIL_MAP.get(userID);

  }

}
