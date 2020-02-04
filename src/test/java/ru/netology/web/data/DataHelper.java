package ru.netology.web.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Finance;
import lombok.Value;

import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }



    @Value
    public static class MoneyTransfer {
        private String amount;
        private String cardNumber;

    }

    public static MoneyTransfer firstCardInfo() {
        String amount = Integer.toString(getRandomAmount(10000));
        return new MoneyTransfer(amount,"5559 0000 0000 0001");
    }
        public static MoneyTransfer putCountToSecondCard() {
            String amount = Integer.toString(getRandomAmount(10000));
            return new MoneyTransfer(amount, "5559 0000 0000 0002");
        }

    public static int getRandomAmount (int max) {
        Random random = new Random ();
        return random.nextInt(max);
    }

}
