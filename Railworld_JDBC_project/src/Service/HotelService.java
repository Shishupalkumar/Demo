package Service;

import Dao.GuestDAO;
import Dao.ReservationDAO;
import Dao.RoomDAO;

import Models.Guest;
import Models.Reservation;
import Models.Room;

import java.sql.SQLException;
import java.util.List;

public class HotelService {
    private GuestDAO guestDAO;
    //Private ReservationDAO  reservationDAO;


    public HotelService() {
        guestDAO = new GuestDAO();
    }

    public void addGuest(Guest guest) throws SQLException {
        guestDAO.addGuest(guest);
    }
    public Guest getGuestById(int id) throws SQLException {
        return guestDAO.getGuestById(id);
    }

    public List<Guest> getAllGuest() throws SQLException {
        return guestDAO.getAllGuest();
    }

    public void updateGuest(Guest guest) throws SQLException {
        guestDAO.updateGuest(guest);
    }

    public void deleteGuest(int id) throws SQLException {
        guestDAO.deleteGuest(id);
    }

}