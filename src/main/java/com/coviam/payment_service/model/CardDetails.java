package com.coviam.payment_service.model;

import com.coviam.payment_service.util.Auditable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Transaction")
@Table(name="transaction")
@EntityListeners(AuditingEntityListener.class)
public class CardDetails extends Auditable<String> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cardNumber")
    @NotNull
    private String cardNumber;

    @Column(name = "nameOnCard")
    @NotNull
    private String nameOnCard;

    @Column(name = "expDate")
    @NotNull
    private String expDate;

    @OneToMany(
            mappedBy = "cardDetails",
            cascade = CascadeType.ALL,
            fetch=FetchType.EAGER
    )
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public CardDetails(){

    }

    public CardDetails(String cardNumber, String nameOnCard, String expDate) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
    }
}
