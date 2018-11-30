package com.example.thenext.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Created by Matthias Skou 30/11/2018
 */

@Entity
public class Company extends User {

//    @OneToMany
    private String companyName;
    private Integer CVR;
    private Offer offer;
    private String businessHours;
    private Long accountInformation;

    public Company() {
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCVR() {
        return CVR;
    }

    public void setCVR(Integer CVR) {
        this.CVR = CVR;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public Long getAccountInformation() {
        return accountInformation;
    }

    public void setAccountInformation(Long accountInformation) {
        this.accountInformation = accountInformation;
    }
}
