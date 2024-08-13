package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequest {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
