package model;

public class EmailAuthentication extends Middleware {
    private String email;

    public EmailAuthentication(String email) {
        this.email = email;
    }

    @Override
    protected boolean checkAuthentication() {
        // Check email
        System.out.println("Checking email: " + email);
        return true;
    }
}