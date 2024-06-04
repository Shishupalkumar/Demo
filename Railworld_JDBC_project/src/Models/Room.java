package Models;

public class Room {
    private int roomId;
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean availability;

    public Room(int roomId, int roomNumber, String roomType, double price, boolean availability) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.availability = availability;
    }

    public Room() {
    }

    // Getters & Setters


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }
}
