package com.mycompany.spring_mvc_project_final.repository;


import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.enums.Status;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    @Query(value = "SELECT * FROM product "
            + "WHERE productId IN ("
            + "SELECT DISTINCT product_id "
            + "FROM auction "
            + "LEFT JOIN account "
            + "ON auction.account_id = account.id "
            + "LEFT JOIN account_role "
            + "ON account.id = account_role.user_id "
            + "WHERE account_role.role_id LIKE %?1% AND auction.status = ?2)"
            , nativeQuery = true)
    List<ProductEntity> findByView1(String id, String status);

    @Query(value = "SELECT * FROM product "
            + "WHERE productId IN ("
            + "SELECT DISTINCT product_id "
            + "FROM auction "
            + "WHERE auction.auction_id = ?1)"
            , nativeQuery = true)
    ProductEntity findByView2(long id);
}

