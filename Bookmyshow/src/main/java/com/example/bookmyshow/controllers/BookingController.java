package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookTicketRequest;
import com.example.bookmyshow.dtos.BookTicketResponse;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.BookingStatus;
import com.example.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    private BookTicketResponse bookTicket(BookTicketRequest bookTicketRequest) {
        BookTicketResponse bookTicketResponse = new BookTicketResponse();
        try {
            Booking booking = this.bookingService.bookTicket(
                    bookTicketRequest.getUserId(),
                    bookTicketRequest.getShowId(),
                    bookTicketRequest.getShowSeatIds());
            bookTicketResponse.setBooking(booking);
            bookTicketResponse.setStatus(BookingStatus.CONFIRMED);
            return bookTicketResponse;
        } catch (Exception e) {
            bookTicketResponse.setStatus(BookingStatus.CONFIRMED);
            return bookTicketResponse;
        }
    }
}
