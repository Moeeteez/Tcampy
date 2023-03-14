package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.Activity;
import com.example.TunisiaCamp.Entity.Booking;

import java.util.List;
import java.util.Map;

public interface IBookingService {
    Booking ajouterActivity(Booking booking);
    Booking updateBooking(Booking booking);
    List<Booking> retriveAllBooking();
    Booking retriveBooking(Long id);
    void deleteBooking(Long id);
    public Map<String, Object> getBookingStatistics();
}
