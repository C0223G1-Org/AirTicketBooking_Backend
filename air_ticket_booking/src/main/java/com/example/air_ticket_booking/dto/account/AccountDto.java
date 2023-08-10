package com.example.air_ticket_booking.dto.account;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class AccountDto {
//    @NotBlank(message = "Không được để trống trường này")
//    @Size(max = 50, min = 10)
//    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$", message = "Bạn phải viết hoa chữ cái đầu của từng từ và có khoảng trắng giữa các từ")
    private String nameCustomer;
//    @NotBlank(message = "Không được để trống trường này")
    private Boolean genderCustomer;
//    @NotBlank(message = "Không được để trống trường này")
//    @Pattern(regexp = "^\\w+@\\w+(.\\w+)$", message = "Nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    private String emailCustomer;
//    @NotBlank(message = "Không được để trống trường này")
//    @Pattern(regexp = "^(\\+84|0)[1-9][0-9]{8}$", message = "Nhập theo định dạng 0xxxxxxxxx với x là ký tự số")
    private String telCustomer;
//    @NotBlank(message = "Không được để trống trường này")
    private String addressCustomer;

    private String imgCustomer;
//    @NotBlank(message = "Không được để trống trường này")
    private String nationalityCustomer;
//    @NotBlank(message = "Không được để trống trường này")
//    @Pattern(regexp = "^([A-Z][0-9]{6})|([0-9]{12})$", message = "Nhập theo định dạng (7 ký tự đối với hộ chiếu và 12 ký tự đối với CCCD)")
    private String idCardCustomer;
//    @NotBlank(message = "Không được để trống trường này")
    private String dateCustomer;
    private Boolean flagCustomer = false;
//    @NotBlank(message = "Không được để trống trường này")
//    @Size(min = 8, max = 20, message = "Mật khẩu phải từ 8 ký tự và ít hơn 20 ký tự")
    private String password;

    public AccountDto( String nameCustomer, Boolean genderCustomer, String emailCustomer, String telCustomer, String addressCustomer, String imgCustomer, String nationalityCustomer, String idCardCustomer, String dateCustomer, Boolean flagCustomer, String password) {

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
        this.password = password;
    }

    public AccountDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
