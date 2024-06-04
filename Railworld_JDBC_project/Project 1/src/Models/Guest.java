package Models;

public class Guest {
    private int guestId;
    private String firstName;
    private String lastName;
    private String email;

    public Guest(int guestId, String firstName, String lastName, String email) {
        this.guestId = guestId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Guest() {
    }


    public static void add(Guest guest) {

    }

    // getter and setter
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

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
