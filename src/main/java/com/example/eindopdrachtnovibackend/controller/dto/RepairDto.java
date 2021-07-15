package com.example.eindopdrachtnovibackend.controller.dto;

public class RepairDto {
    private long customerId;
    private long repairJobId;
    private String examination;
    private String customerAgrees;
    private String actions;


    public long getRepairJobId() {
        return repairJobId;
    }

    public void setRepairJobId(long repairJobId) {
        this.repairJobId = repairJobId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
    }

    public String getCustomerAgrees() {
        return customerAgrees;
    }

    public void setCustomerAgrees(String customerAgrees) {
        this.customerAgrees = customerAgrees;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}
