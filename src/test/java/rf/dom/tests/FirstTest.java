package rf.dom.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends TestConfig{
    @Test

    public void first(){
        open("/");
        $$(".header__nav").findBy(Condition.text("Для бизнеса")).click();
    }
}
