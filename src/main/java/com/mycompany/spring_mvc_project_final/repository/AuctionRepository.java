package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.enums.Status;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> {
    @Query(value = "SELECT * FROM auction "
            + "WHERE product_id LIKE %?1% "
            + "ORDER BY startPrice DESC LIMIT 1", nativeQuery = true)
    AuctionEntity findByViewPrice(long id);

    @Query(value = "SELECT * FROM auction "
            + "WHERE endTime IS NOT NULL AND status = 'ACTIVE'", nativeQuery = true)
    List<AuctionEntity> findByViewEndTime();

    @Modifying
    @Transactional
    @Query(value = "UPDATE auction SET status = 'UNACTIVE' WHERE auction_id = ?1", nativeQuery = true)
    void updateAuctionById(long id);

    @Query(value = "SELECT * FROM auction "
            + "WHERE product_id LIKE %?1% AND status = 'PENDING' "
            + "ORDER BY startPrice DESC LIMIT 1", nativeQuery = true)
    AuctionEntity findByViewPro(long id);
}