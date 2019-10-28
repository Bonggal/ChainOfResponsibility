package model;

public class CaptchaAuthentication extends Middleware {
    private String capthca;

    public CaptchaAuthentication(String capthca) {
        this.capthca = capthca;
    }

    @Override
    protected boolean checkAuthentication() {
        // Process Captcha
        System.out.println("Processing captcha: " + capthca);
        return true;
    }
}