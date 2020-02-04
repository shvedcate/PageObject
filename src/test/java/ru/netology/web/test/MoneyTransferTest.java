package ru.netology.web.test;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.CardChoosePage;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {


    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);

        val transferDashboard = new CardChoosePage();
        transferDashboard.chooseCardForTransfer();


        val transferPage = new TransferPage();
        val cardInfo = DataHelper.firstCardInfo();
        transferPage.putMoneyCard(cardInfo);
    }
   }
