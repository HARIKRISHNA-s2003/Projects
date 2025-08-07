package hotel;

public class Room {
    private int roomNumber;
    private String type;
    private boolean isBooked;

    public Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
    }

    public int getRoomNumber() { 
        return roomNumber; 
    }

    public String getType() { 
        return type; 
    }

    public boolean isBooked() { 
        return isBooked; 
    }

    public void bookRoom() { 
        isBooked = true; 
    }

    public void vacateRoom() { 
        isBooked = false; 
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + type + ") - " + 
               (isBooked ? "Booked" : "Available");
    }
}
