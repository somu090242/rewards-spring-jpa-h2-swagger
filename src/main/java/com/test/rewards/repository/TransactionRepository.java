package com.test.rewards.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.rewards.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	@Query(value = "SELECT * FROM TRANSACTION where USER_ID=:userId and TRANSACTION_DATE between :fromDate and :toDate", nativeQuery = true)
	List<Transaction> getRewardsInrange(Long userId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}
