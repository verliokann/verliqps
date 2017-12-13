package ru.verlioka.cmf.appservices.zverevvv.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "client_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "account")
    private String account;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private BigInteger amount;

    @OneToOne
    @JoinColumn(name = "deposit_type")
    private DepositTypeEntity depositInfo;

    @OneToOne
    @JoinColumn(name = "bank_branch")
    private BankBranchEntity bankBranchInfo;
}
