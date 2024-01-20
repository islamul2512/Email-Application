public class Email {
    protected String emailId;
    protected String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }
    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(password) && isValidPassword(newPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password change failed. Please check the conditions.");
        }
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*") &&
                password.matches(".*[^a-zA-Z\\d].*");
    }

}
