package com.infoplus.bankmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankManagementDto {
    private Long id;
    private String bankCode;

    private String bankName;

    private String binCode;

    private boolean active;
}
