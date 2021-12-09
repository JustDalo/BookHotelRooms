package by.tc.task04.entity;

import java.util.Objects;

public class HotelRoom implements Database {
    private long id;
    private int squareMeters;
    private int maxAdults;
    private int maxChildren;
    private long price;

    public HotelRoom(long id, int squareMeters, int maxAdults, int maxChildren, long price) {
        this.id = id;
        this.squareMeters = squareMeters;
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.price = price;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelRoom)) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return id == hotelRoom.id && squareMeters == hotelRoom.squareMeters && maxAdults == hotelRoom.maxAdults && maxChildren == hotelRoom.maxChildren && price == hotelRoom.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, squareMeters, maxAdults, maxChildren, price);
    }

    public long getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults) {
        this.maxAdults = maxAdults;
    }

    public int getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(int maxChildren) {
        this.maxChildren = maxChildren;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

}
