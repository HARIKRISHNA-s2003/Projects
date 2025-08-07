package hotel;

public class Booking {
    private Room room;
    private Guest guest;
    private int days;

    public Booking(Room room, Guest guest, int days) {
        this.room = room;
        this.guest = guest;
        this.days = days;
    }

    public Room getRoom() { 
        return room; 
    }

    public Guest getGuest() { 
        return guest; 
    }

    public int getDays() { 
        return days; 
    }

    @Override
    public String toString() {
        return guest + " booked " + room + " for " + days + " days";
    }
}
