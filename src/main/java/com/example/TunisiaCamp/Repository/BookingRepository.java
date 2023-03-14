package com.example.TunisiaCamp.Repository;

import com.example.TunisiaCamp.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("SELECT campcenter.idCamp, count(b) FROM Booking b JOIN b.centre campcenter GROUP BY campcenter")
    List<Object[]> countAppointmentsPerUser();


}
