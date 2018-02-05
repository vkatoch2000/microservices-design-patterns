package com.aggregate.service;


import com.aggregate.client.ConferenceBookingMicroServiceFeignProxy;
import com.aggregate.client.FlightBookingMicroServiceFeignProxy;
import com.aggregate.client.HotelBookingMicroServiceFeignProxy;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class AggregatorService {


   @Resource
   FlightBookingMicroServiceFeignProxy flightBookingMicroServiceFeignProxy;


   @Resource
   ConferenceBookingMicroServiceFeignProxy conferenceBookingMicroServiceFeignProxy;


   @Resource
   HotelBookingMicroServiceFeignProxy hotelBookingMicroServiceFeignProxy;



   public Map<String,Object> getBookingDetails(String id) {
      Map<String,Object> bookingDetailsInoList = new LinkedHashMap<>();
      bookingDetailsInoList.put("conference",conferenceBookingMicroServiceFeignProxy.getBookingDetail(id));
      bookingDetailsInoList.put("hotel",hotelBookingMicroServiceFeignProxy.getBookingDetail(id));
      return bookingDetailsInoList;
   }







}
