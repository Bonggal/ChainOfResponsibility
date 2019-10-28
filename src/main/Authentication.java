package main;

import model.*;

public class Authentication {
    private Middleware authenticationSystem;

    public boolean process() {
        return authenticationSystem.checkNextMiddleware();
    }

    public static final class AuthenticationBuilder {
        private Middleware authenticationSystem;

        AuthenticationBuilder() {
        }

        public static AuthenticationBuilder anAuthentication() {
            return new AuthenticationBuilder();
        }

        public AuthenticationBuilder withEmailAuthentication(String email) {
            Middleware emailAuthentication = new EmailAuthentication(email);
            emailAuthentication.setNextProcess(this.authenticationSystem);
            this.authenticationSystem = emailAuthentication;
            return this;
        }

        public AuthenticationBuilder withPasswordAuthentication(String password) {
            Middleware passwordAuthentication = new PasswordAuthentication(password);
            passwordAuthentication.setNextProcess(this.authenticationSystem);
            this.authenticationSystem = passwordAuthentication;
            return this;
        }

        public AuthenticationBuilder withCapthcaAuthentication(String captcha) {
            Middleware captchaAuthentication = new CaptchaAuthentication(captcha);
            captchaAuthentication.setNextProcess(this.authenticationSystem);
            this.authenticationSystem = captchaAuthentication;
            return this;
        }

        public AuthenticationBuilder withPinAuthentication(String pinNumber) {
            Middleware pinAuthentication = new PinAuthentication(pinNumber);
            pinAuthentication.setNextProcess(this.authenticationSystem);
            this.authenticationSystem = pinAuthentication;
            return this;
        }

        public Authentication build() {
            Authentication authentication = new Authentication();
            authentication.authenticationSystem = this.authenticationSystem;
            return authentication;
        }
    }
}