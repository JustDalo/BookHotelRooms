package by.tc.task04.service;

import by.tc.task04.entity.Booking;
import by.tc.task04.exceptions.ServiceException;

import java.util.Date;
import java.util.List;

public interface BookingService {
    Booking bookRoom(Long userId, long roomId, Date startDate, Date lastDate, int adultsCount, int childrenCount) throws ServiceException;

    List<Booking> findByUser(Long id);

    List<Booking> findAll();
}
