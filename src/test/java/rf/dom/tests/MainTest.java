package rf.dom.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class MainTest extends TestConfig {
    @ParameterizedTest(name = "Проверка видимости элемента {0} в меню направлений")
    @ValueSource(strings = {"ДОМ.РФ", "Аренда ДОМ.РФ", "Наш ДОМ.РФ", "ЩЛЗ", "СОПФ агент", "ДОМ.РФ Девелопмент", "ДОМ.РФ Земля и Недвижимость",
            "Городская среда", "Программы господдержки", "Цифровая академия", "Ипотечный агент"})
    void directionsTest(String testDate) {
        mainPage.openPage()
                .openAllDirections()
                .checkMenuDirection(testDate);
    }

    @Test
    @DisplayName("Проверка поисковой строки")
    void searchTest() {
        mainPage.openPage()
                .clickSearch()
                .setValueSearchBar("Ипотека")
                .checkSearchResult("Ипотека для IT-специалистов")
                .checkSearchResult("Льготная ипотека")
                .checkSearchResult("Семейная ипотека");
    }

    @Test
    @DisplayName("Проверка элементов Burger меню")
    void burgerMenuTest(){
        mainPage.openPage()
                .clickBurgerMenu()
                .checkElementsBurgerMenu("О компании")
                .checkElementsBurgerMenu("Карьера")
                .checkElementsBurgerMenu("Инвесторам")
                .checkElementsBurgerMenu("Аналитика")
                .checkElementsBurgerMenu("Новости")
                .checkElementsBurgerMenu("Контакты");
    }
}
