package com.review.reviewservice.models;

import com.review.reviewservice.dtos.RatingType;
import com.review.reviewservice.dtos.ServiceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String serviceName;
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;
    private String city;
    @Enumerated(EnumType.STRING)
    private RatingType rating;

}
