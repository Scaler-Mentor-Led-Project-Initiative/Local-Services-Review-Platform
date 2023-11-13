package com.review.reviewservice.repositories;

import com.review.reviewservice.dtos.RatingType;
import com.review.reviewservice.dtos.ServiceType;
import com.review.reviewservice.models.LocalBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalBusinessRepository extends JpaRepository<LocalBusiness,Long> {

    List<LocalBusiness> findAllByServiceName(String name);
    List<LocalBusiness> findAllByServiceType(ServiceType type);
    List<LocalBusiness> findAllByRating(RatingType ratingType);
}
