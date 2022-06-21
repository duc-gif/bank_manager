package com.infoplus.bankmanagement.service.ipml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoplus.bankmanagement.Repository.BankManagementRepository;
import com.infoplus.bankmanagement.entity.BankManagement;
import com.infoplus.bankmanagement.model.BankManagementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BankManagementServiceImpl implements BankManagementService {
    @Autowired
    private ObjectMapper objectMappers;
    @Autowired
    private BankManagementRepository repository;

    @Override
    @Transactional
    public List<BankManagement> getAllListBankManagement() {
        return repository.findAll();
    }


    @Override
    @Transactional
    public BankManagement save(BankManagementDto bankManagementDto) {
        BankManagement bank = objectMappers.convertValue(bankManagementDto, BankManagement.class);
        return repository.save(bank);
    }

    @Override
    @Transactional
    public Optional<BankManagement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public BankManagement saveAndFlush(BankManagement bankManagement) {
        return repository.saveAndFlush(bankManagement);
    }


}
