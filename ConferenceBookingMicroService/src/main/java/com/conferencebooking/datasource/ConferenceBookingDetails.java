package com.conferencebooking.datasource;

import com.conferencebooking.model.BookingDetail;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class ConferenceBookingDetails {


 public final static Map<String, BookingDetail> BOOKING_DETAIL_MAP = ImmutableMap.<String, BookingDetail>builder().
  put("1", new BookingDetail("C01", "01-01-2017", "05-01-2017", "details")).
  put("2", new BookingDetail("C02", "11-01-2017", "15-01-2017", "details")).
  put("3", new BookingDetail("C03", "01-02-2017", "05-02-2017", "details")).
  put("4", new BookingDetail("C04", "11-02-2017", "15-02-2017", "details")).
  put("5", new BookingDetail("C05", "01-03-2017", "05-03-2017", "details")).
  build();



}
