package com.adil.electricitybilling.repository;

import com.adil.electricitybilling.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    // Custom queries (if needed) can go here
}
