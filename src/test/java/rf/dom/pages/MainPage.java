package rf.dom.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement
            allDirections = $(".header-buttons-internal__text"),
            searchIcon = $(".header-buttons__search"),
            searchString = $(".search__field"),
            burgerMenu = $(".burger-button");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage openAllDirections() {
        allDirections.click();
        return this;
    }

    public MainPage checkMenuDirection(String value) {
        $$(".internal-list").shouldHave(CollectionCondition.texts(value));
        return this;
    }

    public MainPage clickSearch() {
        searchIcon.click();

        return this;
    }

    public MainPage setValueSearchBar(String value) {
        searchString.setValue(value).pressEnter();

        return this;
    }

    public MainPage checkSearchResult(String value) {
        $$(".search__result").shouldHave(CollectionCondition.texts(value));

        return this;
    }

    public MainPage clickBurgerMenu() {
        burgerMenu.click();

        return this;
    }

    public MainPage checkElementsBurgerMenu(String value){
        $$(".menu-burger-nav__main").shouldHave(CollectionCondition.texts(value));

        return this;
    }
}