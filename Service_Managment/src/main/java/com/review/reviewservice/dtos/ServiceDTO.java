package com.review.reviewservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private String serviceName;
    private ServiceType serviceType;
    private String city;
    private RatingType rating;

}
