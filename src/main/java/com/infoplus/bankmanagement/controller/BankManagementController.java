package com.infoplus.bankmanagement.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoplus.bankmanagement.entity.BankManagement;
import com.infoplus.bankmanagement.model.BankManagementDto;
import com.infoplus.bankmanagement.res.Res;
import com.infoplus.bankmanagement.service.ipml.BankManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bank_manage")
public class BankManagementController {

    @Autowired
    private ObjectMapper objectMappers;

    @Autowired
    private BankManagementService bankManagementService;

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bankManagementService.getAllListBankManagement());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addBankManagement(@RequestBody BankManagementDto bankManagementDto) {
        return ResponseEntity.ok(new Res(bankManagementService.save(bankManagementDto), "Create successful", true));
    }
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody BankManagementDto bankManagementDto) {
        Optional<BankManagement> bankManagement = bankManagementService.findById(id);
        BankManagement bank = objectMappers.convertValue(bankManagement, BankManagement.class);
        bank.setId(id);
        bank.setBankCode(bankManagementDto.getBankCode());
        bank.setBankName(bankManagementDto.getBankName());
        bank.setBinCode(bankManagementDto.getBinCode());
        BankManagement bankMg = bankManagementService.saveAndFlush(bank);
        return ResponseEntity.ok(new Res(bankMg, "Update successful", true));
    }

    @PostMapping("/close/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestBody BankManagementDto bankManagementDto) {
        Optional<BankManagement> bankManagement = bankManagementService.findById(id);
        BankManagement bank = objectMappers.convertValue(bankManagement, BankManagement.class);
        bank.setId(id);
        bank.setActive(false);
        BankManagement bankMg = bankManagementService.saveAndFlush(bank);
        return ResponseEntity.ok(new Res(bankMg, "Close successful", true));
    }
    }
