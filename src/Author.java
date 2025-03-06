public class Author {
    private String firstName;
    private String lastName;

    Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Author that = (Author) object;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    public int hashCode() {
        int result = firstName == null ? 0 : firstName.hashCode();
        result = result * 31 + (lastName == null ? 0 : lastName.hashCode());
        return result;
    }
}
