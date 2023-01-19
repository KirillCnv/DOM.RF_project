package rf.dom.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement
            allDirections = $(".header-buttons-internal__text");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage openAllDirections() {
        allDirections.click();
        return  this;
    }

    public MainPage checkMenuDirection(String value){
        $$(".internal-list").shouldHave(CollectionCondition.texts(value));

        return  this;
    }
}
