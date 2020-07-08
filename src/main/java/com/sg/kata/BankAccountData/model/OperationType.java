package com.sg.kata.BankAccountData.model;

public enum OperationType {

    DEPOSIT("deposit"),
    WITHDRAW("withdraw");

    private final String operationType;


    private OperationType(String operationType) {
        this.operationType = operationType;
    }
}
