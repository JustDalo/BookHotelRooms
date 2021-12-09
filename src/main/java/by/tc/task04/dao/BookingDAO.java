package by.tc.task04.dao;

import by.tc.task04.entity.Booking;

import java.util.List;

public interface BookingDAO extends DAO<Booking> {
    boolean canBook(Booking booking);

    List<Booking> findByUserId(Long userId);
}
