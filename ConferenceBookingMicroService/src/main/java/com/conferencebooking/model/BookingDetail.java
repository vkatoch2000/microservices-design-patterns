package com.conferencebooking.model;

public class BookingDetail {

  private String bookingID;
  private String from;
  private String to;
  private String details;


  public String getBookingID() {
    return bookingID;
  }

  public void setBookingID(String bookingID) {
    this.bookingID = bookingID;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }


  public BookingDetail(String bookingID, String from, String to, String details){
    this.bookingID = bookingID;
    this.from = from;
    this.to = from;
    this.details = details;

  }


}
