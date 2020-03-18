package com.example.JPAWithHibernatePart2.Table_Per_Class;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepositorys extends CrudRepository<PaymentParent,Integer> {
}
