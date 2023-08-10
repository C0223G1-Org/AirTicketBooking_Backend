package com.example.air_ticket_booking.dto.customer;

import com.example.air_ticket_booking.model.account.Account;

import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class CustomerDto {
    private Long idCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Size(max = 30)
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$", message = "Bạn phải viết hoa chữ cái đầu của từng từ và có khoảng trắng giữa các từ")
    private String nameCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private Boolean genderCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^\\w+@\\w+(.\\w+)$", message = "Nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    private String emailCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^0[0-9]{9}", message = "Nhập theo định dạng 0xxxxxxxxx với x là ký tự số")
    private String telCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String addressCustomer;

    private String imgCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String nationalityCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^[0-9]{12}", message = "Nhập vào 12 ký tự số liên tiếp")
    private String idCardCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String dateCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private Boolean flagCustomer;
    private Account account;

    public CustomerDto() {
    }

    public CustomerDto(Long idCustomer, String nameCustomer, Boolean genderCustomer, String emailCustomer, String telCustomer, String addressCustomer, String imgCustomer, String nationalityCustomer, String idCardCustomer, String dateCustomer, Boolean flagCustomer, Account account) {
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
