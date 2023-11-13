package com.review.reviewservice.controllers;

import com.review.reviewservice.dtos.RatingType;
import com.review.reviewservice.dtos.ServiceDTO;
import com.review.reviewservice.dtos.ServiceType;
import com.review.reviewservice.models.LocalBusiness;
import com.review.reviewservice.services.LocalBusinessService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ServiceController.class)
class ServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalBusinessService localBusinessService;

    @Test
    public void getServiceDetailsById() throws Exception {
        Mockito.when(localBusinessService.getServiceById(1L)).thenReturn(new ServiceDTO("test-service", ServiceType.AUTO_SERVICES, "test-city", RatingType.GOOD));
        mockMvc.perform(MockMvcRequestBuilders.get("/services/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.serviceName").value("test-service"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serviceType").value(ServiceType.AUTO_SERVICES.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("test-city"));

    }

    @Test
    public void getServiceDetailsByMissingId() throws Exception {
        Mockito.when(localBusinessService.getServiceById(1L)).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/services/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

    @Test
    public void getServiceDetails() throws Exception {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        serviceDTOList.add(new ServiceDTO("test-service", ServiceType.AUTO_SERVICES, "test-city",RatingType.VERY_GOOD));
        serviceDTOList.add(new ServiceDTO("test-service2", ServiceType.RESTAURANT, "test-city2",RatingType.EXCELLENT));
        Mockito.when(localBusinessService.getServices()).thenReturn(serviceDTOList);
        mockMvc.perform(MockMvcRequestBuilders.get("/services"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"serviceName\":\"test-service\",\"serviceType\":\"AUTO_SERVICES\",\"city\":\"test-city\"},{\"serviceName\":\"test-service2\",\"serviceType\":\"RESTAURANT\",\"city\":\"test-city2\"}]"));
    }

    @Test
    public void addServices() throws Exception {
        //ServiceDTO serviceDTO = new ServiceDTO("test-service", ServiceType.AUTO_SERVICES, "test-city",RatingType.VERY_GOOD);
        Mockito.when(localBusinessService.addServices(ArgumentMatchers.any(ServiceDTO.class)))
                .thenReturn(new LocalBusiness(1L, "test-service", ServiceType.AUTO_SERVICES, "test-city",RatingType.GOOD));
        mockMvc.perform(MockMvcRequestBuilders.post("/services")
                .contentType("application/json")
                .content("{\"serviceName\":\"test-service\",\"serviceType\":\"AUTO_SERVICES\",\"city\":\"test-city\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serviceName").value("test-service"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.serviceType").value(ServiceType.AUTO_SERVICES.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("test-city"));
    }
    @Test
    public void getServiceDetailsByName() throws Exception {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        serviceDTOList.add(new ServiceDTO("test-service", ServiceType.AUTO_SERVICES, "test-city",RatingType.GOOD));
        serviceDTOList.add(new ServiceDTO("test-service2", ServiceType.RESTAURANT, "test-city2",RatingType.VERY_GOOD));
        List<ServiceDTO> returnList = new ArrayList<>();
        returnList.add(serviceDTOList.get(0));
        Mockito.when(localBusinessService.getByServiceName("test-service")).thenReturn(returnList);
        mockMvc.perform(MockMvcRequestBuilders.get("/services?name=test-service"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"serviceName\":\"test-service\",\"serviceType\":\"AUTO_SERVICES\",\"city\":\"test-city\"}]"));
    }
    @Test
    public void getServiceDetailsByType() throws Exception {
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        serviceDTOList.add(new ServiceDTO("test-service", ServiceType.AUTO_SERVICES, "test-city",RatingType.GOOD));
        serviceDTOList.add(new ServiceDTO("test-service2", ServiceType.RESTAURANT, "test-city2",RatingType.VERY_GOOD));
        List<ServiceDTO> returnList = new ArrayList<>();
        returnList.add(serviceDTOList.get(0));
        Mockito.when(localBusinessService.getByServiceType(ServiceType.AUTO_SERVICES)).thenReturn(returnList);
        mockMvc.perform(MockMvcRequestBuilders.get("/services?type=AUTO_SERVICES"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"serviceName\":\"test-service\",\"serviceType\":\"AUTO_SERVICES\",\"city\":\"test-city\"}]"));
    }
}