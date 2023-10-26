package entities;

public class Room {
    private Student rentalOwner;
    private int room;

    public Room(Student rentalOwner, int room) {
        this.rentalOwner = rentalOwner;
        this.room = room;
    }

    public Student getRentalOwner() {
        return rentalOwner;
    }

    public void setRentalOwner(Student rentalOwner) {
        this.rentalOwner = rentalOwner;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String toString() {
        return String.format("%d", room)
                + ": " + rentalOwner;
    }
}
