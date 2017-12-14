package ru.verlioka.cmf.appservices.zverevvv.controllers.reports;

import java.math.BigInteger;
import java.util.Date;

public class CustomerReport {
    private String bankBranchAddress;
    private String bankBranchDetails;
    private String clientName;
    private String clientAccount;
    private BigInteger clientAmount;
    private String depositName;
    private Date dateOfDeposit;

    public CustomerReport(String bankBranchAddress, String bankBranchDetails, String clientName, String clientAccount, BigInteger clientAmount, String depositName, Date dateOfDeposit) {
        this.bankBranchAddress = bankBranchAddress;
        this.bankBranchDetails = bankBranchDetails;
        this.clientName = clientName;
        this.clientAccount = clientAccount;
        this.clientAmount = clientAmount;
        this.depositName = depositName;
        this.dateOfDeposit = dateOfDeposit;
    }

    public String getBankBranchAddress() {
        return bankBranchAddress;
    }

    public void setBankBranchAddress(String bankBranchAddress) {
        this.bankBranchAddress = bankBranchAddress;
    }

    public String getBankBranchDetails() {
        return bankBranchDetails;
    }

    public void setBankBranchDetails(String bankBranchDetails) {
        this.bankBranchDetails = bankBranchDetails;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(String clientAccount) {
        this.clientAccount = clientAccount;
    }

    public BigInteger getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(BigInteger clientAmount) {
        this.clientAmount = clientAmount;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public Date getDateOfDeposit() {
        return dateOfDeposit;
    }

    public void setDateOfDeposit(Date dateOfDeposit) {
        this.dateOfDeposit = dateOfDeposit;
    }
}
