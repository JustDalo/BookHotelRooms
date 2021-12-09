package by.tc.task04.dao.impl;

import by.tc.task04.dao.HotelRoomDAO;
import by.tc.task04.entity.HotelRoom;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelRoomDAOImpl extends DAOImpl<HotelRoom> implements HotelRoomDAO {

    private static final String ROOM_SQUARE_METERS = "square_meters";
    private static final String ROOM_ID = "id";
    private static final String ROOM_MAX_ADULTS = "max_adults";
    private static final String ROOM_MAX_CHILDREN = "max_childrens";
    private static final String ROOM_PRICE = "room_price";
    private static final String ROOM_TABLE_NAME = "hotel_rooms";

    private static HotelRoomDAOImpl instance;

    public HotelRoomDAOImpl() {
        super(ROOM_TABLE_NAME);
    }

    public static HotelRoomDAOImpl getInstance() {
        HotelRoomDAOImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (UserDAOImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new HotelRoomDAOImpl();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }
    @Override
    protected String getValuesForSaving(HotelRoom entity) {
        return String.format("(%d, %d, %d, %d)",
                entity.getSquareMeters(),
                entity.getMaxAdults(),
                entity.getMaxChildren(),
                entity.getPrice());
    }

    @Override
    protected String getFieldsNames() {
        return String.format("%s, %s, %s, %s",
                ROOM_SQUARE_METERS, ROOM_MAX_ADULTS, ROOM_MAX_CHILDREN, ROOM_PRICE);
    }

    @Override
    protected HotelRoom mapResultSet(ResultSet resultSet) throws SQLException {
        return new HotelRoom(resultSet.getLong(ROOM_ID),
                resultSet.getInt(ROOM_SQUARE_METERS),
                resultSet.getInt(ROOM_MAX_ADULTS),
                resultSet.getInt(ROOM_MAX_CHILDREN),
                resultSet.getLong(ROOM_PRICE));
    }
}
