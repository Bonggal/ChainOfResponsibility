package model;

public class PinAuthentication extends Middleware {
    private String pinNumber;

    public PinAuthentication(String pinNumber){
        this.pinNumber = pinNumber;
    }

    @Override
    protected boolean checkAuthentication() {
        System.out.println("Processing pin number: " + pinNumber);
        return true;
    }
}