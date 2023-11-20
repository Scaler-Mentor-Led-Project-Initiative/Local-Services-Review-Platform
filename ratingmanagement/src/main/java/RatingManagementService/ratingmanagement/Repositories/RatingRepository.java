package RatingManagementService.ratingmanagement.Repositories;

import RatingManagementService.ratingmanagement.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RatingRepository extends JpaRepository<Rating, Long>{


    @Query("DELETE FROM Rating r WHERE r.userId = ?1 AND r.serviceId = ?2")
    void deleteBYUserIdAndServiceId(long userId, long serviceId);

    @Query("SELECT r FROM Rating r WHERE r.userId = ?1 AND r.serviceId = ?2")
    Rating findByUSerIdAndServiceId(long userId, long serviceId);

    @Query("Select Avg(r.rating) from Rating r where r.serviceId=?1")
    Double getAverageRatingByServiceId(long serviceId);

    int countRatingsByServiceIdEquals(long serviceId);
}
