package com.example.air_ticket_booking.dto.account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AccountDto implements Validator {
    @NotBlank(message = "Không được để trống trường này")
    @Size(max = 50, min = 10, message = "Họ và tên phải hơn 10 ký tự và dưới 50 ký tự")
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$", message = "Bạn phải viết hoa chữ cái đầu của từng từ, có khoảng trắng giữa các từ và không có ký tự đặc biệt")
    private String nameCustomer;
//    @NotBlank(message = "Không được để trống trường này")
    private Boolean genderCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^\\w+@\\w+(.\\w+)$", message = "Nhập theo định dạng: xxx@xxx.xxx với x không phải là ký tự đặc biệt ")
    @Size(max = 50,min = 12,message = "Email tối đa 50 ký tự, ít nhất 12 ký tự")
    private String emailCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^(\\+84|0)[1-9][0-9]{8}$", message = "Nhập theo định dạng +84xxxxxxxxx hoặc 0xxxxxxxxx với x là ký tự số")
    private String telCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String addressCustomer;

    private String imgCustomer;
    @NotBlank(message = "Không được để trống trường này")
    private String nationalityCustomer;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^([A-Z][0-9]{6,12})|([0-9]{12})$", message = "Nhập theo định dạng (7 ký tự đối với hộ chiếu và 12 ký tự đối với CCCD)")
    private String idCardCustomer;
    @NotBlank(message = "Không được để trống trường này")

    private String dateCustomer;
    private Boolean flagCustomer = false;
    @NotBlank(message = "Không được để trống trường này")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).{8,20}$", message = "Mật khẩu phải từ 8 ký tự và ít hơn 20 ký tự, có chứa ký ự in hoa và ký tự số")
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    /**
     * Create by: NhanDT
     *  Date create: 11/08/2023
     *  Function: validate age of customer must be over 18 years old
     * @param target
     * @return errors
     */
    @Override
    public void validate(Object target, Errors errors) {

//        LocalDate birthday = LocalDate.of(2000, 1, 1); // Ngày sinh của người cần kiểm tra
//
//        LocalDate currentDate = LocalDate.now();
//        Period age = Period.between(birthday, currentDate);
//
//        int years = age.getYears();

        AccountDto accountDto = (AccountDto) target;
        String date = accountDto.dateCustomer;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(date, formatter);
        LocalDate today = LocalDate.now();
        Period age = Period.between(dateOfBirth, today);
        int years = age.getYears();
//        if (today.getMonthValue() < dateOfBirth.getMonthValue()
//                || (today.getMonthValue() == dateOfBirth.getMonthValue() && today.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
//            age--; //Age reduction if the birthday is not reached in the current year
//
//        }
        if (years <= 18) {
            errors.rejectValue("dateCustomer", "dateCustomer", "Khách hàng phải trên 18 tuổi");
        }

    }
}
