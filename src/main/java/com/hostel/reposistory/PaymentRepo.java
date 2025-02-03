package com.hostel.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hostel.entity.Candidate;
import com.hostel.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

	@Query(value = "select sum(remaning_amount) from hostel_management.payment", nativeQuery = true)
	long totalRemaningAmount();

	@Query(value = "select sum(paying_amount) from hostel_management.payment", nativeQuery = true)
	long totalRecivedAmount();

	@Query(value = "SELECT remaning_amount FROM hostel_management.payment WHERE id = :id", nativeQuery = true)
	Double findRemaingAmountById(Long id);

	@Query(value = "SELECT paying_amount FROM hostel_management.payment WHERE id = :id", nativeQuery = true)
	Double findPayingAmountById(Long id);

	@Query("SELECT a FROM Payment a WHERE a.uniqueid = :uniqueid")
	Payment findByEmail(@Param("uniqueid") int uniqueid);
}
