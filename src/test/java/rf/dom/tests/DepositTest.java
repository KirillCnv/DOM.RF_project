package rf.dom.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class DepositTest extends TestConfig{
    @Test
    @DisplayName("Проверка работы калькулятора по вкладу")
    void checkRate(){
        mainPage.openPage();
        $("a[title=\"Вклад до 9,8%\"]").click();
        depositPage.checkDepositCalc("1000000",9.8);
    }
}
