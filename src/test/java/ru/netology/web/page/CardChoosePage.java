package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CardChoosePage {
    private SelenideElement firstCardTransferButton = $("[data-test-id='action-deposit']");
    private SelenideElement secondCardTransferButton = $("[data-test-id='action-deposit']").lastChild();
    private SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public DashboardPage chooseCardForTransfer(){
        int countOfFirstCard = 0;
        int countOfSecondCard = 0;
        String str = firstCardString.toString();
        String[] firstCardList = str.split(" ");
        for (int i = 0; i < firstCardList.length; i++){
            countOfFirstCard = Integer.parseInt(firstCardList[6]);
        }
        String str2 = secondCardString.toString();
        String[] secondCardList = str2.split(" ");
        for (int i = 0; i < secondCardList.length; i++){
            countOfSecondCard = Integer.parseInt(secondCardList[6]);
        }

        if (countOfFirstCard >= countOfSecondCard){
            firstCardTransferButton.click();
        } else secondCardTransferButton.click();
        return new DashboardPage();
    }
}
