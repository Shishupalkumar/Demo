package hotel.model;

//package hotel.model;

import java.sql.Date;

public class Reservation {
    private int reservationId;
    private int userId;
    private int roomId;
    private Date startDate;
    private Date endDate;

    public Reservation(int reservationId, int userId, int roomId, Date startDate, Date endDate) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

