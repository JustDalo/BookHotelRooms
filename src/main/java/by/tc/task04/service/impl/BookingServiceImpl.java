package by.tc.task04.service.impl;

import by.tc.task04.dao.BookingDAO;
import by.tc.task04.dao.HotelRoomDAO;
import by.tc.task04.dao.UserDAO;
import by.tc.task04.dao.impl.BookingDAOImpl;
import by.tc.task04.dao.impl.HotelRoomDAOImpl;
import by.tc.task04.dao.impl.UserDAOImpl;
import by.tc.task04.entity.Booking;
import by.tc.task04.exceptions.DAOException;
import by.tc.task04.exceptions.ServiceException;
import by.tc.task04.service.BookingService;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private final BookingDAO bookDAO = BookingDAOImpl.getInstance();
    private final UserDAO userDAO = UserDAOImpl.getInstance();
    private final HotelRoomDAO hotelRoomDAO = HotelRoomDAOImpl.getInstance();

    @Override
    public Booking bookRoom(Long userId, long roomId, Date startDate, Date lastDate, int adultsCount, int childrenCount) throws ServiceException {
        if (userDAO.findById(userId).isEmpty()){
            throw new ServiceException("Such User is not exist!");
        }
        if (hotelRoomDAO.findById(roomId).isEmpty()){
            throw new ServiceException("Such Room is not exist!");
        }

        Booking booking = new Booking(startDate, lastDate, adultsCount, childrenCount, roomId, userId);

        if (bookDAO.canBook(booking)) {
            try {
                return bookDAO.save(booking);
            } catch (DAOException e) {
                throw new ServiceException(e.getMessage());
            }
        } else {
            throw new ServiceException("This room is already booked in this time!");
        }
    }

    @Override
    public List<Booking> findByUser(Long id) {
        return bookDAO.findByUserId(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookDAO.findAll();
    }
}
