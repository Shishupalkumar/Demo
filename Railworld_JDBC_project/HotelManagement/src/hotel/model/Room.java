package hotel.model;

//package com.hotel.model;

public class Room {
    private int roomId;
    private String roomNumber;
    private String status;

    public Room(int roomId, String roomNumber, String status) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

