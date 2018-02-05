package com.aggregate.client;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name="conferencebookingservice")
public interface ConferenceBookingMicroServiceFeignProxy {



  @GetMapping("/conference/booking/{id}/details")
  public Object getBookingDetail(@PathVariable(name = "id") String userID) ;



}
