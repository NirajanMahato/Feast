package com.example.feast.Repo;

import com.example.feast.Entity.EventBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventBookingRepo extends JpaRepository<EventBooking , Long> {
}
