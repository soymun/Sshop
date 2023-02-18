package com.example.shop.Repository;

import com.example.shop.Entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFoodRepository extends JpaRepository<UserProduct, Long> {

    List<UserProduct> getUserProductsByUserIdAndVisible(Long id, boolean visible);
}
