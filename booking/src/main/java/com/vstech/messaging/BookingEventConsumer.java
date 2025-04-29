package com.vstech.messaging;


import com.vstech.modal.PaymentOrder;

import com.vstech.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingEventConsumer {


    private final BookingService bookingService;

    @RabbitListener(queues = "booking-queue")
    public void bookingUpdateListener(PaymentOrder paymentOrder){

        System.out.println("Received message: " + paymentOrder);

        bookingService.bookingSucess(paymentOrder);

        System.out.println("Received message: " + paymentOrder);

    }
}
