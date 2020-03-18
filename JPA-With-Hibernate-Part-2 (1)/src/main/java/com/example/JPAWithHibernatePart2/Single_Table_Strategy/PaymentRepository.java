package com.example.JPAWithHibernatePart2.Single_Table_Strategy;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
