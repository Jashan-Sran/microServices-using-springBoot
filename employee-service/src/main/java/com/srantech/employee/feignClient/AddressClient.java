package com.srantech.employee.feignClient;

import com.srantech.employee.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jashan",url = "http://localhost:8080/address-app/api/")
public interface AddressClient { //proxy

    @GetMapping("/address/{id}")
    AddressResponse getAddressByPassingEmployeeId(@PathVariable("id") int id);
}
