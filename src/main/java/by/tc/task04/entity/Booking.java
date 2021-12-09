package by.tc.task04.entity;

import java.util.Date;
import java.util.Objects;

public class Booking implements Database {
    private long id;
    private Date checkIn;
    private Date checkOut;
    private int adultsNumber;
    private int childrenNumber;
    private long roomId;
    private long userId;

    public Booking(long id, Date checkIn, Date checkOut, int adultsNumber, int childrenNumber, long roomId, long userId) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
        this.roomId = roomId;
        this.userId = userId;
    }

    public Booking(Date checkIn, Date checkOut, int adultsNumber, int childrenNumber, long roomId, long userId) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
        this.roomId = roomId;
        this.userId = userId;
    }


    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return id == booking.id && adultsNumber == booking.adultsNumber && childrenNumber == booking.childrenNumber && roomId == booking.roomId && userId == booking.userId && Objects.equals(checkIn, booking.checkIn) && Objects.equals(checkOut, booking.checkOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkIn, checkOut, adultsNumber, childrenNumber, roomId, userId);
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getAdultsNumber() {
        return adultsNumber;
    }

    public void setAdultsNumber(int adultsNumber) {
        this.adultsNumber = adultsNumber;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
