package mandatory.two.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Matthias Skou 30/11/2018
 */

@Entity
public class Company extends User {

    @OneToMany
    private List<Offer> offerList;
    private String companyName;
    private Integer CVR;
    private String businessHours;
    private Long accountInformation;

    public Company() {
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
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
