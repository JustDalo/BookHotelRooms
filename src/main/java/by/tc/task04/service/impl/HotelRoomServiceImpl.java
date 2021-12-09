package by.tc.task04.service.impl;

import by.tc.task04.dao.impl.HotelRoomDAOImpl;
import by.tc.task04.entity.HotelRoom;
import by.tc.task04.service.HotelRoomService;

import java.util.List;
import java.util.Optional;

public class HotelRoomServiceImpl implements HotelRoomService {
    private final HotelRoomDAOImpl hotelRoomDAO = HotelRoomDAOImpl.getInstance();

    @Override
    public List<HotelRoom> findAll() {
        return hotelRoomDAO.findAll();
    }

    @Override
    public Optional<HotelRoom> findById(long id) {
        return hotelRoomDAO.findById(id);
    }
}
