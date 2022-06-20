package com.infoplus.bankmanagement.Repository;

import com.infoplus.bankmanagement.entity.BankManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankManagementRepository extends JpaRepository<BankManagement,Long> {
    BankManagement saveAndFlush(BankManagement bankManagement);

}
