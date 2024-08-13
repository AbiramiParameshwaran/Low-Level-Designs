package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.BookTicketResponse;
import com.example.bookmyshow.exceptions.ShowNotFoundException;
import com.example.bookmyshow.exceptions.ShowSeatBlockedOrBooked;
import com.example.bookmyshow.exceptions.ShowSeatException;
import com.example.bookmyshow.exceptions.UserNotFoundException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.ShowSeatRepository;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    public Booking bookTicket(Long userId, Long showid, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatException, ShowSeatBlockedOrBooked {
        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }
        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showid);
        if(optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show not Found");
        }
        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        if(showSeats.isEmpty()) {
            throw new ShowSeatException("Seat Not Found");
        }

        for (ShowSeat showSeat: showSeats) {
            if(!showSeat.getShowStatus().equals(ShowStatus.FREE)) {
                throw new ShowSeatBlockedOrBooked("Seat is blocked or Booked, Please choose other seats");
            }
        }

        for (ShowSeat showSeat: showSeats) {
            showSeat.setShowStatus(ShowStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowseats(showSeats);
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setAmount(100L);
        return booking;
    }
}
