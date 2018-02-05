package com.aggregate.controller;


import com.aggregate.service.AggregatorService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The aggregator aggregates calls on various micro-services, collects
 * data and further publishes them under a REST endpoint.
 */

@RestController
@RequestMapping("aggregate")
public class AggregatorController {

  @Autowired
  AggregatorService aggregatorService;


  @GetMapping("/user/{id}/booking-detail")
  public Map<String,Object> getBookingInfo(@PathVariable(name = "id") String userid) {
    return aggregatorService.getBookingDetails(userid);
  }


}
