package com.infoplus.bankmanagement.service.ipml;

import com.infoplus.bankmanagement.entity.BankManagement;
import com.infoplus.bankmanagement.model.BankManagementDto;

import java.util.List;
import java.util.Optional;

public interface BankManagementService {

    List<BankManagement> getAllListBankManagement();

    public BankManagement save(BankManagementDto bankManagementDto);

    Optional<BankManagement> findById(Long id);
    BankManagement saveAndFlush(BankManagement bankManagement);

}
