package ru.ecomshop.productservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ecomshop.productservice.model.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}