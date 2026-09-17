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
}
