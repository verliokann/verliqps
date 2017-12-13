package ru.verlioka.cmf.appservices.zverevvv.controllers.reports;

import java.math.BigInteger;
import java.util.Date;

public class BankBranchReport {
    private int BankBranchNumber;
    private String clientName;
    private String clientAccount;
    private Date depositData;
    private BigInteger clientAmount;
    private Double depositPercent;
    private int depositDuration;

    public BankBranchReport(int bankBranchNumber, String clientName, String clientAccount, Date depositData, BigInteger clientAmount, Double depositPercent, int depositDuration) {
        BankBranchNumber = bankBranchNumber;
        this.clientName = clientName;
        this.clientAccount = clientAccount;
        this.depositData = depositData;
        this.clientAmount = clientAmount;
        this.depositPercent = depositPercent;
        this.depositDuration = depositDuration;
    }

    public int getBankBranchNumber() {
        return BankBranchNumber;
    }

    public void setBankBranchNumber(int bankBranchNumber) {
        BankBranchNumber = bankBranchNumber;
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

    public Date getDepositData() {
        return depositData;
    }

    public void setDepositData(Date depositData) {
        this.depositData = depositData;
    }

    public BigInteger getClientAmount() {
        return clientAmount;
    }

    public void setClientAmount(BigInteger clientAmount) {
        this.clientAmount = clientAmount;
    }

    public Double getDepositPercent() {
        return depositPercent;
    }

    public void setDepositPercent(Double depositPercent) {
        this.depositPercent = depositPercent;
    }

    public int getDepositDuration() {
        return depositDuration;
    }

    public void setDepositDuration(int depositDuration) {
        this.depositDuration = depositDuration;
    }
}
