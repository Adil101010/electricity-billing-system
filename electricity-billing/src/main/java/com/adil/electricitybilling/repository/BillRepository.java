package com.adil.electricitybilling.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adil.electricitybilling.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    // custom queries if needed
    List<Bill> findByConsumerId(Long consumerId);
    List<Bill> findByPaidTrue();
    List<Bill> findByPaidFalse();
    @Query("SELECT SUM(b.amount) FROM Bill b WHERE b.consumer.id = :consumerId AND b.paid = false")
    Double getTotalDueAmountByConsumerId(@Param("consumerId") Long consumerId);


}
