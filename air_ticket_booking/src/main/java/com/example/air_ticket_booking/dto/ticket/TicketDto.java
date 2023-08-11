package com.example.air_ticket_booking.dto.ticket;

import com.example.air_ticket_booking.model.customer.Customer;
import com.example.air_ticket_booking.model.luggage.Luggage;
import com.example.air_ticket_booking.model.seat.Seat;
import com.example.air_ticket_booking.model.ticket.TypeTicket;
import com.example.air_ticket_booking.model.type_passenger.TypePassenger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 *class : class use verify the validity of the data
 * created by :NamPC
 * date create: 10/08/2023
 */

public class TicketDto implements Validator {
    private Long idTicket;
    private Long priceTicket;
    private Boolean flagTicket;
    @NotBlank(message = "Không được để trống")
    @Size(max = 50,message = "Tên không vượt quá 50 ký tự")
    @Size(min = 10, message = "Tên ít nhất 10 ký tự")
    @Pattern(regexp = "^([A-Z][a-z]{0,7}\\s){1,5}[A-Z][a-z]{0,7}$",message = "Tên không đúng định dạng")
    private String namePassenger;
    @NotBlank(message = "Không được để trống")
    private Boolean genderPassenger;
    @Pattern(regexp = "/^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$/\n",message = "Email không đúng định dạng")
    private String emailPassenger;
    @Pattern(regexp = "^(84|0)(3|5|7|8|9)[0-9]{8}$",message = "Số điện thoại phải đúng định dạng")
    private  String telPassenger;
    @Pattern(regexp = "^([0-9]{12})|([A-Z][0-9]{7})$",message = "12 số với CCCD, 8 số với Passport")
    private String idCardPassenger;
    private String dateBooking;
    private TypeTicket typeTicket;
    private Luggage luggage;
    private TypePassenger typePassenger;
    private Seat seat;
    private Customer customer;

    public TicketDto(Long idTicket, Long priceTicket, Boolean flagTicket, String namePassenger, Boolean genderPassenger,
                     String emailPassenger, String telPassenger, String idCardPassenger, String dateBooking,
                     TypeTicket typeTicket, Luggage luggage, TypePassenger typePassenger, Seat seat, Customer customer) {
        this.idTicket = idTicket;
        this.priceTicket = priceTicket;
        this.flagTicket = flagTicket;
        this.namePassenger = namePassenger;
        this.genderPassenger = genderPassenger;
        this.emailPassenger = emailPassenger;
        this.telPassenger = telPassenger;
        this.idCardPassenger = idCardPassenger;
        this.dateBooking = dateBooking;
        this.typeTicket = typeTicket;
        this.luggage = luggage;
        this.typePassenger = typePassenger;
        this.seat = seat;
        this.customer = customer;
    }

    public TicketDto() {
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Long priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Boolean getFlagTicket() {
        return flagTicket;
    }

    public void setFlagTicket(Boolean flagTicket) {
        this.flagTicket = flagTicket;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public void setNamePassenger(String namePassenger) {
        this.namePassenger = namePassenger;
    }

    public Boolean getGenderPassenger() {
        return genderPassenger;
    }

    public void setGenderPassenger(Boolean genderPassenger) {
        this.genderPassenger = genderPassenger;
    }

    public String getEmailPassenger() {
        return emailPassenger;
    }

    public void setEmailPassenger(String emailPassenger) {
        this.emailPassenger = emailPassenger;
    }

    public String getTelPassenger() {
        return telPassenger;
    }

    public void setTelPassenger(String telPassenger) {
        this.telPassenger = telPassenger;
    }

    public String getIdCardPassenger() {
        return idCardPassenger;
    }

    public void setIdCardPassenger(String idCardPassenger) {
        this.idCardPassenger = idCardPassenger;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public TypeTicket getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(TypeTicket typeTicket) {
        this.typeTicket = typeTicket;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public TypePassenger getTypePassenger() {
        return typePassenger;
    }

    public void setTypePassenger(TypePassenger typePassenger) {
        this.typePassenger = typePassenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
