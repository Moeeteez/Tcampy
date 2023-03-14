package com.example.TunisiaCamp.Controllers;

import com.example.TunisiaCamp.Entity.Activity;
import com.example.TunisiaCamp.Entity.Booking;
import com.example.TunisiaCamp.Entity.CampCentre;
import com.example.TunisiaCamp.Services.ActivityService;
import com.example.TunisiaCamp.Services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("TCampy")
@CrossOrigin(origins = "http://localhost:8081")

public class BookingController {
    BookingService bookingService;
    @PostMapping("/ajouterBooking")
    Booking ajouterBooking(@RequestBody Booking booking)
    {
        return bookingService.ajouterActivity(booking);
    }
    @PutMapping("/updateBooking")
    Booking updateBooking(@RequestBody Booking booking)
    {
        return bookingService.updateBooking(booking);
    }

    @GetMapping("/afficheAllBooking")
    List<Booking> retriveAllBooking()
    {
        return bookingService.retriveAllBooking();
    }

    @GetMapping("/afficheBooking/{id}")
    Booking retriveBooking(@PathVariable Long id)
    {
        return bookingService.retriveBooking(id);
    }
    @DeleteMapping("/deleteBooking/{id}")
    void deleteBooking(@PathVariable Long id) {bookingService.deleteBooking(id);}
    @GetMapping("/BookingStatistics")
    public Map<String, Object> getAppointmentStatistics() {
        return bookingService.getBookingStatistics();
    }

}
