package rf.dom.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import rf.dom.helper.Attach;
import rf.dom.pages.MainPage;
import rf.dom.pages.deposit.DepositPage;
import rf.dom.utils.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestConfig {

    Attach attach = new Attach();
    public MainPage mainPage = new MainPage();
    public DepositPage depositPage = new DepositPage();
//    public CheckSearchLinePage checkSearchLinePage = new CheckSearchLinePage();
//    public ContactlessDeliveryPage contactlessDeliveryPage = new ContactlessDeliveryPage();
//    public PayWhenYouWantPage payWhenYouWantPage = new PayWhenYouWantPage();

    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Properties config = ConfigFactory.create(Properties.class, System.getProperties());

        String browserName = String.valueOf(config.getBrowser());
        String browserVersion = config.getBrowserVersion();
        String browserResolution = config.getResolution();

        Configuration.browser = browserName;
        Configuration.browserVersion = browserVersion;
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserSize = browserResolution;
        Configuration.baseUrl = config.getBaseUrl();

        if (config.getRemote()){
            String selenoidLogin = config.getSelenoidLogin(),
                    selenoidPassword = config.getSelenoidPassword();

            Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub",
                    selenoidLogin, selenoidPassword);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        Attach.attachAsText("Browser: ", browserName);
        Attach.attachAsText("Version: ", browserVersion);
        Attach.attachAsText("Remote: ", String.valueOf(config.getRemote()));
        Attach.attachAsText("Login: ", config.getSelenoidLogin());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
