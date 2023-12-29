package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.BidEntity;
import com.mycompany.spring_mvc_project_final.entities.CreditEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<CreditEntity, Long> {
    CreditEntity findByAccount_id(long account_id);
}