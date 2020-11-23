package com.ong.springswagger.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ong.springswagger.models.PaymentLog;



@Repository
public interface PaymentLogRepository extends JpaRepository<PaymentLog, Long>{

}
