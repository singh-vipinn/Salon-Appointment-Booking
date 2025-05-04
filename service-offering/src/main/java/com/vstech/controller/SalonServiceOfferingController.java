package com.vstech.controller;

import com.vstech.modal.ServiceOffering;
import com.vstech.payload.dto.CategoryDTO;
import com.vstech.payload.dto.SalonDTO;
import com.vstech.payload.dto.ServiceDTO;
import com.vstech.service.ServiceOfferingService;
import com.vstech.service.clients.CategoryFeignClient;
import com.vstech.service.clients.SalonFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;
    private final SalonFeignClient salonService;
    private final CategoryFeignClient categoryService;

    @PostMapping
    public ResponseEntity<ServiceOffering> createService(
            @RequestHeader("Authorization") String jwt,
            @RequestBody ServiceDTO service) throws Exception {

        SalonDTO salon=salonService.getSalonByOwner(jwt).getBody();

        CategoryDTO category=categoryService
                .getCategoryById(service.getCategory()).getBody();

        ServiceOffering createdService = serviceOfferingService
                .createService(service,salon,category);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @PatchMapping("/{serviceId}")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long serviceId,
            @RequestBody ServiceOffering service) throws Exception {
        ServiceOffering updatedService = serviceOfferingService
                .updateService(serviceId, service);
        if (updatedService != null) {
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
