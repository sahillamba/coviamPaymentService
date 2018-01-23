package com.coviam.payment_service.model;

import com.coviam.payment_service.util.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.smartcardio.Card;
import javax.validation.constraints.NotNull;

@Entity(name="Transaction")
@Table(name="transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction  extends Auditable<String> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "txnId")
    @NotNull
    private String txnId;

    @Column(name = "itnId")
    @NotNull
    private String itnId;

    @Column(name = "amount")
    @NotNull
    private String amount;

    @Column(name = "providerId")
    @NotNull
    private String providerId;

    @Column(name = "paymentMethod")
    @NotNull
    private String paymentMethod;

    public static enum Status {active, inactive, deferred, cancelled};

    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    private Transaction.Status paymentStatus = Transaction.Status.active;

    @Column(name="customer_id")
    @NotNull
    private String customer_id;

    @ManyToOne
    @JoinColumn(name = "cardDetails_id")
    @JsonBackReference
    private CardDetails cardDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getItnId() {
        return itnId;
    }

    public void setItnId(String itnId) {
        this.itnId = itnId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public Transaction(){

    }

    public Transaction(String txnId, String itnId, String amount, String providerId, String paymentMethod, Status paymentStatus, String customer_id) {
        this.txnId = txnId;
        this.itnId = itnId;
        this.amount = amount;
        this.providerId = providerId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.customer_id = customer_id;
    }
}
