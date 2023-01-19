package rf.dom.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MainTest extends TestConfig {
    @ParameterizedTest
    @ValueSource(strings = {"ДОМ.РФ", "Аренда ДОМ.РФ","Наш ДОМ.РФ","ЩЛЗ","СОПФ агент","ДОМ.РФ Девелопмент","ДОМ.РФ Земля и Недвижимость",
            "Городская среда","Программы господдержки","Цифровая академия","Ипотечный агент"})
    void directionsTest(String testDate) {
        mainPage.openPage()
                .openAllDirections()
                .checkMenuDirection(testDate);

    }
}
