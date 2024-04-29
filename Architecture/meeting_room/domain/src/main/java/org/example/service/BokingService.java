package org.example.service;

import org.example.entity.Booking;
import org.example.entity.Room;

import org.example.entity.User;
import org.example.port.IBaseRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BokingService {
    private IBaseRepository bookingRepository;

    public BokingService(IBaseRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public void createBooking(User user,Room room,LocalDate date, LocalTime startTime, LocalTime endTime) {
        // Vérifier si la date de réservation est dans le futur
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La date de réservation est déjà passée.");
        }

        Booking booking = new Booking.Builder()
                .user(user)
                .room(room)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .build();

        bookingRepository.create(booking);
    }
    public Booking findBookingById(int bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public List<Booking>  searchBooking (String search){
        List<Booking> list = bookingRepository.findAll(search);
        return list;
    }
    public void updateBooking(int bookingId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        Booking booking = bookingRepository.findById(bookingId);
        if (booking != null) {
            booking.setDate(date);
            booking.setStartTime(startTime);
            booking.setEndTime(endTime);
            bookingRepository.update(booking);
        } else {
            throw new IllegalArgumentException("Booking with ID " + bookingId + " not found");
        }
    }
    public void deleteBooking(int bookingId) {
        Booking booking = bookingRepository.findById(bookingId);
        if (booking != null) {
            bookingRepository.delete(booking);
        } else {
            throw new IllegalArgumentException("Booking with ID " + bookingId + " not found");
        }
    }
}
