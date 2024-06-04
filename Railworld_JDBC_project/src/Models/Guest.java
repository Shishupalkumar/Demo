package Models;

public class Guest {
    private int guestId;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private int room_no;

    public Guest(int guestId, String firstName, String lastName, String email, String contact, int room_no) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contact = contact;
        this.room_no = room_no;
    }

    public Guest() {
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getRoom_no(int room_no) {
        return this.room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", room_no=" + room_no +
                '}';
    }
}
