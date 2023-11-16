package com.mycompany.spring_mvc_project_final.repository;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
