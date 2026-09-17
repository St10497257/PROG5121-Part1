package prog5121poe;

public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String username, String password,
                 String cellPhoneNumber,
                 String firstName, String lastName) {

        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
} 
// Username must contain an underscore and
// must not be more than five characters long.
public boolean checkUserName() {
    return username.contains("_") && username.length() <= 5;
}
    // Password must contain at least 8 characters,
// a capital letter, a number and a special character.
public boolean checkPasswordComplexity() {
    boolean hasCapital = password.matches(".*[A-Z].*");
    boolean hasNumber = password.matches(".*[0-9].*");
    boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

    return password.length() >= 8
            && hasCapital
            && hasNumber
            && hasSpecial;
}
    // Checks that the cellphone number uses the
// South African international +27 format.
public boolean checkCellPhoneNumber() {
    return cellPhoneNumber.matches("^\\+27\\d{9}$");
}
    public String registerUser() {

    if (!checkUserName()) {
        return "Username is not correctly formatted; please ensure "
                + "that your username contains an underscore and is "
                + "no more than five characters in length.";
    }

    if (!checkPasswordComplexity()) {
        return "Password is not correctly formatted; please ensure "
                + "that the password contains at least eight characters, "
                + "a capital letter, a number, and a special character.";
    }

    if (!checkCellPhoneNumber()) {
        return "Cell phone number incorrectly formatted or does not "
                + "contain international code.";
    }

    return "User registered successfully.";
}

public boolean loginUser(String enteredUsername, String enteredPassword) {
    return username.equals(enteredUsername)
            && password.equals(enteredPassword);
}

public String returnLoginStatus(String enteredUsername,
                                String enteredPassword) {

    if (loginUser(enteredUsername, enteredPassword)) {
        return "Welcome " + firstName + ", " + lastName
                + " it is great to see you again.";
    }

    return "Username or password incorrect, please try again.";
}
