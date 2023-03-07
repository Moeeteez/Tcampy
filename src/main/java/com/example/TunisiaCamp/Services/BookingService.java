package com.example.TunisiaCamp.Services;

import com.example.TunisiaCamp.Entity.Booking;
import com.example.TunisiaCamp.Repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor

public class BookingService implements IBookingService{

    BookingRepository bookingRepository;
    @Override
    public Booking ajouterActivity(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> retriveAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking retriveBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBooking(Long id) {bookingRepository.deleteById(id);}

    @Override
    public Map<String, Object> getBookingStatistics() {
        Map<String, Object> statistics = new HashMap<>();

        // nmbre total de reservation
        long totalBookings = bookingRepository.count();
        statistics.put("totalBookings", totalBookings);

        // nmbre de réservation pour chaque campcenter
        List<Object[]> BookingPerCampCenter = bookingRepository.countAppointmentsPerUser();
        Map<String, Long> bookingsPerCampCenterMap = new HashMap<>();
        for (Object[] result : BookingPerCampCenter) {
            bookingsPerCampCenterMap.put(result[0].toString(), (Long) result[1]);
        }
        statistics.put("BookingPerCampCenter", bookingsPerCampCenterMap);



        return statistics;
    }

}
