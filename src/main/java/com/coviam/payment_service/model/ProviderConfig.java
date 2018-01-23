package com.coviam.payment_service.model;

import com.coviam.payment_service.util.Auditable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name="ProviderConfig")
@Table(name="provider_config")
@EntityListeners(AuditingEntityListener.class)
public class ProviderConfig  extends Auditable<String> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "providerName")
    @NotNull
    private String providerName;

    @Column(name = "providerUrl")
    @NotNull
    private String providerUrl;

    @Column(name = "providerCallbackUrl")
    @NotNull
    private String providerCallbackUrl;

    @Column(name = "providerCredentialKey1")
    @NotNull
    private String providerCredentialKey1;

    @Column(name = "providerCredentialKey2")
    @NotNull
    private String providerCredentialKey2;


    public static enum Status {active, inactive, deferred, cancelled};

    @Column(name = "providerStatus")
    @Enumerated(EnumType.STRING)
    private Status providerStatus = Status.active;

    @OneToMany(
            mappedBy = "providerConfig",
            cascade = CascadeType.ALL,
            fetch=FetchType.EAGER
    )
    @JsonManagedReference
    private List<BusinessConfig> businessConfigDetails = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public String getProviderCallbackUrl() {
        return providerCallbackUrl;
    }

    public void setProviderCallbackUrl(String providerCallbackUrl) {
        this.providerCallbackUrl = providerCallbackUrl;
    }

    public String getProviderCredentialKey1() {
        return providerCredentialKey1;
    }

    public void setProviderCredentialKey1(String providerCredentialKey1) {
        this.providerCredentialKey1 = providerCredentialKey1;
    }

    public String getProviderCredentialKey2() {
        return providerCredentialKey2;
    }

    public void setProviderCredentialKey2(String providerCredentialKey2) {
        this.providerCredentialKey2 = providerCredentialKey2;
    }

    public Enum getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(Status providerStatus) {
        this.providerStatus = providerStatus;
    }

    public List<BusinessConfig> getBusinessConfigDetails() {
        return businessConfigDetails;
    }

    public void setBusinessConfigDetails(List<BusinessConfig> businessConfigDetails) {
        this.businessConfigDetails = businessConfigDetails;
    }

    public ProviderConfig(){

    }

    public ProviderConfig(String providerName, String providerUrl, String providerCallbackUrl, String providerCredentialKey1, String providerCredentialKey2, Status providerStatus) {
        this.providerName = providerName;
        this.providerUrl = providerUrl;
        this.providerCallbackUrl = providerCallbackUrl;
        this.providerCredentialKey1 = providerCredentialKey1;
        this.providerCredentialKey2 = providerCredentialKey2;
        this.providerStatus = providerStatus;
    }
}
