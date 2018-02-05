package com.conferencebooking.service;


import com.conferencebooking.model.BookingDetail;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

@Component
public class HotelBookingService {

  @HystrixCommand(fallbackMethod = "getDefaultDetail")
  public BookingDetail getBookingDetail(String userID){
    throw new RuntimeException("no data found");
  }

  public BookingDetail getDefaultDetail(String id){
    return new BookingDetail("-1","","","no data found for useid "+id);

  }



}
