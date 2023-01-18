package rf.dom.utils;

@org.aeonbits.owner.Config.Sources({
        "classpath:properties/properties.properties"
})
public interface Properties extends org.aeonbits.owner.Config {


    @Key("Browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("99.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://xn--d1aqf.xn--p1ai/")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getResolution();

    @Key("remote")
    @DefaultValue("false")
    boolean getRemote();

    @Key("selenoidLogin")
    String getSelenoidLogin();

    @Key("selenoidPassword")
    String getSelenoidPassword();

}
