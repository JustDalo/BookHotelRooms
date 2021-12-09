package by.tc.task04.service;

import by.tc.task04.entity.HotelRoom;

import java.util.List;
import java.util.Optional;

public interface HotelRoomService {
    List<HotelRoom> findAll();

    Optional<HotelRoom> findById(long id);
}
