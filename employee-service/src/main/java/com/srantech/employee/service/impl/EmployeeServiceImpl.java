package com.srantech.employee.service.impl;

import com.srantech.employee.entity.Employee;
import com.srantech.employee.repository.EmployeeRepo;
import com.srantech.employee.response.AddressResponse;
import com.srantech.employee.response.EmployeeResponse;
import com.srantech.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public EmployeeResponse getEmployeeDetails(int id) {

        Employee employee = employeeRepo.findById(id).get();
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8080/address-app/api/address/{id}",AddressResponse.class,id);
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }


}
