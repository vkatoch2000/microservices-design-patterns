package com.aggregate.client;


import com.netflix.client.config.IClientConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="HotelBookingMicroService",fallback = HotelBookingMicroServiceFeignProxy.HotelBookingFallback.class)
public interface HotelBookingMicroServiceFeignProxy {

  @GetMapping("/hotel/booking/{id}/details")
  public Object getBookingDetail(@PathVariable(name = "id") String userID) ;

  @Component
   class HotelBookingFallback implements  HotelBookingMicroServiceFeignProxy {
    @Override
    public Object getBookingDetail(@PathVariable(name = "id") String userID) {
      return " HotelBookingService service down ";
    }
  }


}
