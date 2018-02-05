package com.aggregate.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name="conferencebookingservice")
public interface FlightBookingMicroServiceFeignProxy {

}
