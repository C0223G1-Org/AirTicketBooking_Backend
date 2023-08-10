package com.example.air_ticket_booking.model.customer;

import com.example.air_ticket_booking.model.account.Account;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    private String nameCustomer;
    private Boolean genderCustomer;
    private String emailCustomer;
    private String telCustomer;
    private String addressCustomer;
    private String imgCustomer;
    private String nationalityCustomer;
    private String idCardCustomer;
    private String dateCustomer;
    private Boolean flagCustomer;

  @OneToOne
    private Account account;

    public Customer() {
    }

    public Customer(Long idCustomer, String nameCustomer, Boolean genderCustomer, String emailCustomer, String telCustomer, String addressCustomer, String imgCustomer, String nationalityCustomer, String idCardCustomer, String dateCustomer, Boolean flagCustomer, Account account) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.genderCustomer = genderCustomer;
        this.emailCustomer = emailCustomer;
        this.telCustomer = telCustomer;
        this.addressCustomer = addressCustomer;
        this.imgCustomer = imgCustomer;
        this.nationalityCustomer = nationalityCustomer;
        this.idCardCustomer = idCardCustomer;
        this.dateCustomer = dateCustomer;
        this.flagCustomer = flagCustomer;
        this.account = account;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Boolean getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(Boolean genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTelCustomer() {
        return telCustomer;
    }

    public void setTelCustomer(String telCustomer) {
        this.telCustomer = telCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getImgCustomer() {
        return imgCustomer;
    }

    public void setImgCustomer(String imgCustomer) {
        this.imgCustomer = imgCustomer;
    }

    public String getNationalityCustomer() {
        return nationalityCustomer;
    }

    public void setNationalityCustomer(String nationalityCustomer) {
        this.nationalityCustomer = nationalityCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getDateCustomer() {
        return dateCustomer;
    }

    public void setDateCustomer(String dateCustomer) {
        this.dateCustomer = dateCustomer;
    }

    public Boolean getFlagCustomer() {
        return flagCustomer;
    }

    public void setFlagCustomer(Boolean flagCustomer) {
        this.flagCustomer = flagCustomer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}