package com.vstech.service;

import com.vstech.domain.BookingStatus;
import com.vstech.modal.Booking;
import com.vstech.modal.PaymentOrder;
import com.vstech.modal.SalonReport;
import com.zosh.modal.*;
import com.vstech.payload.dto.SalonDTO;
import com.vstech.payload.dto.ServiceOfferingDTO;
import com.vstech.payload.dto.UserDTO;
import com.vstech.payload.request.BookingRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {


    Booking createBooking(
            BookingRequest booking,
            UserDTO user,
            SalonDTO salon,
            Set<ServiceOfferingDTO> serviceOfferingSet) throws Exception;


    List<Booking> getBookingsByCustomer(Long customerId);


    List<Booking> getBookingsBySalon(Long salonId);


    Booking getBookingById(Long bookingId);

    Booking bookingSucess(PaymentOrder order);


    Booking updateBookingStatus(Long bookingId, BookingStatus status) throws Exception;

    SalonReport getSalonReport(Long salonId);

    List<Booking> getBookingsByDate(LocalDate date,Long salonId);
}
