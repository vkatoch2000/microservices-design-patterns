package com.conferencebooking.datasource;

import com.conferencebooking.model.BookingDetail;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class FlightBookingDetails {


 public final static Map<String, BookingDetail> BOOKING_DETAIL_MAP = ImmutableMap.<String, BookingDetail>builder().
  put("1", new BookingDetail("F01", "DEL", "MEL", "details")).
  put("2", new BookingDetail("F02", "DEL", "GAU", "details")).
  put("3", new BookingDetail("F03", "DEL", "RUS", "details")).
  put("4", new BookingDetail("F04", "DEL", "PHL", "details")).
  put("5", new BookingDetail("F05", "DEL", "CAN", "details")).
  build();



}
