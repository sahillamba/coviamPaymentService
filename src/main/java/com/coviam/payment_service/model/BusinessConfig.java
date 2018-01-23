package com.coviam.payment_service.model;

import com.coviam.payment_service.util.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="BusinessConfig")
@Table(name="business_config")
@EntityListeners(AuditingEntityListener.class)
public class BusinessConfig extends Auditable<String>{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "busniessId")
    private String busniessId;

    @Column(name = "maxAmount")
    private String maxAmount;

    @Column(name = "minAmount")
    private String minAmount;

    @Column(name = "busniessStatus")
    private Enum busniessStatus = com.coviam.payment_service.util.ProviderStatus.active;

    @ManyToOne
    @JoinColumn(name = "providerConfig_id")
    @JsonBackReference
    private ProviderConfig providerConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusniessId() {
        return busniessId;
    }

    public void setBusniessId(String busniessId) {
        this.busniessId = busniessId;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public Enum getBusniessStatus() {
        return busniessStatus;
    }

    public void setBusniessStatus(Enum busniessStatus) {
        this.busniessStatus = busniessStatus;
    }

    public com.coviam.payment_service.model.ProviderConfig getProviderConfig() {
        return providerConfig;
    }

    public void setProviderConfig(com.coviam.payment_service.model.ProviderConfig providerConfig) {
        this.providerConfig = providerConfig;
    }

    public BusinessConfig(){

    }

    public BusinessConfig(String busniessId, String maxAmount, String minAmount, Enum busniessStatus) {
        this.busniessId = busniessId;
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.busniessStatus = busniessStatus;
    }
}
