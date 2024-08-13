package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponse {
    private Booking booking;
    private BookingStatus status;
}
