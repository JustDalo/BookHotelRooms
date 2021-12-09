package by.tc.task04.dao.impl;

import by.tc.task04.dao.BookingDAO;
import by.tc.task04.dao.SqlThrowingConsumer;
import by.tc.task04.entity.Booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BookingDAOImpl extends DAOImpl<Booking> implements BookingDAO {

    private static final String BOOKING_ID = "id";
    private static final String BOOKING_CHEK_IN = "check_in";
    private static final String BOOKING_CHEK_OUT = "check_out";
    private static final String BOOKING_ADULTS_NUMBER = "adults_number";
    private static final String BOOKING_CHILDREN_NUMBER = "children_number";
    private static final String BOOKING_ROOM_ID = "roomId";
    private static final String BOOKING_USER_ID = "userId";
    private static final String BOOKING_TABLE_NAME = "room_booking";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String SQL_CAN_BOOK = "select * from room_booking " +
            "WHERE roomId = %d and( (date(check_in) <= '%s') and (date(check_out) > '%s') or "+
            " (date(check_in) < '%s') and (date(check_out) >= '%s') " +
            "or (date(check_in) >= '%s') and (date(check_out) <= '%s'))";


    private static BookingDAOImpl instance;

    public BookingDAOImpl() { super(BOOKING_TABLE_NAME); }

    public static BookingDAOImpl getInstance() {
        BookingDAOImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (UserDAOImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new BookingDAOImpl();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }

    @Override
    public boolean canBook(Booking booking) {
        String startDay = new SimpleDateFormat(DATE_PATTERN).format(booking.getCheckIn());
        String lastDay = new SimpleDateFormat(DATE_PATTERN).format(booking.getCheckOut());
        List<Booking> entities = findEntities(
                String.format(SQL_CAN_BOOK, booking.getRoomId(), startDay, lastDay, startDay, lastDay, startDay, lastDay)
        );
        return entities.isEmpty();
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        return findPreparedEntities(whereUserId(userId),
                String.format(DAOImpl.FIND_BY_PARAM_SQL_TEMPLATE,tableName, "userId"));
    }

    private static SqlThrowingConsumer<PreparedStatement> whereUserId(long userId) {
        return statement -> {
            statement.setLong(1, userId);
        };
    }

    @Override
    protected String getValuesForSaving(Booking entity) {
        return String.format("('%s', '%s', %d, %d, %d, %d)",
                new SimpleDateFormat(DATE_PATTERN).format(entity.getCheckIn()),
                new SimpleDateFormat(DATE_PATTERN).format(entity.getCheckOut()),
                entity.getAdultsNumber(),
                entity.getChildrenNumber(),
                entity.getRoomId(),
                entity.getUserId());
    }

    @Override
    protected String getFieldsNames() {
        return String.format("%s, %s, %s, %s, %s, %s",
                BOOKING_CHEK_IN, BOOKING_CHEK_OUT, BOOKING_ADULTS_NUMBER, BOOKING_CHILDREN_NUMBER,
                BOOKING_ROOM_ID, BOOKING_USER_ID);
    }

    @Override
    protected Booking mapResultSet(ResultSet resultSet) throws SQLException {
        return new Booking(
                resultSet.getLong(BOOKING_ID),
                resultSet.getDate(BOOKING_CHEK_IN),
                resultSet.getDate(BOOKING_CHEK_OUT),
                resultSet.getInt(BOOKING_ADULTS_NUMBER),
                resultSet.getInt(BOOKING_CHILDREN_NUMBER),
                resultSet.getInt(BOOKING_ROOM_ID),
                resultSet.getInt(BOOKING_USER_ID)
        );
    }
}
