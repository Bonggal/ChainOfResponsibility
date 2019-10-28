package model;

public class PasswordAuthentication extends Middleware {
    private String password;

    public PasswordAuthentication(String password){
        this.password = password;
    }


    @Override
    protected boolean checkAuthentication() {
        // Authentication process
        System.out.println("Processing password: " + password);

        return true;
    }
}