class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String toString() {
        String result = "";
        if (lastName != null) {
            result += lastName + " ";
        }
        if (firstName != null) {
            result += firstName + " ";
        }
        if (middleName != null) {
            result += middleName;
        }
        return result;
    }
}