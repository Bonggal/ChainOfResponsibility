package main;

public class MainProgram {

    public static void main(String[] args) {
        String email = "email";
        String password = "password";
        String captcha = "capthca";
        String pinNumber = "0123";

        Authentication authentication = new Authentication.AuthenticationBuilder()
                .withPinAuthentication(pinNumber)
                .withCapthcaAuthentication(captcha)
                .withPasswordAuthentication(password)
                .withEmailAuthentication(email)
                .build();

        System.out.println("Authentication: " + authentication.process());
    }
}