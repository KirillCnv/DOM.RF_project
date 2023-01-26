package rf.dom.pages.deposit;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import java.text.NumberFormat;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class DepositPage {


    public DepositPage checkDepositCalc(String summa, double rate){

//        double rateResult = summa / 100 * rate;
//        int mInt = (int)rateResult;
//        System.out.println(mInt);
//        int sumResult = summa + mInt ;

        $("#ym-deposit-click-sum").click();
       $("#ym-deposit-click-sum").sendKeys(Keys.CONTROL + "A");
       $("#ym-deposit-click-sum").sendKeys(Keys.BACK_SPACE);
        $("#ym-deposit-click-sum").setValue(summa);

        int sum = Integer.parseInt(summa);
        double rateResult = sum / 100 * rate * 3;
        int mInt = (int)rateResult;
        int sumResult = sum + mInt;
        String.format(Locale.CANADA_FRENCH, "%,d", sumResult);
        String finalSum = sumResult + " ₽";

        $$(".deposits-calculator__result-feat-value").first().shouldHave(Condition.text(finalSum));


        return this;
    }
}