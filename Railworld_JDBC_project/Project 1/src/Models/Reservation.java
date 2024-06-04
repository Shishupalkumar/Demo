package Models;
import java.util.Date;


public class Reservation {
    private  Object email;
    private  int roomNumber;
    private  String guestName;
    private int reservationId;
    private int guestId;
    private int roomId;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(int reservationId, int guestId, int roomId, Date checkInDate, Date checkOutDate) {
        this.reservationId = reservationId;
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Reservation() {
    }

    public Reservation(String guestName, int roomNumber, String email) {
        this.guestName=guestName;
        this.roomNumber=roomNumber;
       this.email=email;
    }

    // getter & setter

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", guestId=" + guestId +
                ", roomId=" + roomId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }

    public Object getGuestName() {
        return null;
    }

    public Object getContactNumber() {
        return null;
    }

    public Object getReservationDate() {
        return null;
    }

    public Object getRoomNumber() {
        return null;
    }
}
