package TestUtils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "file:src/test/resources/propertyFiles/QA.Properties" // mention the property file name
})
public interface ConfigProperty extends Config {

    @Key("baseURI")
    String getBaseURI();

    @Key("basePath")
    String getBasePath();

    @Key("secretKey")
    String getSecretKey();

    @Key("testReportPath")
    String getTestReportFilepath();

    @Key("testReportName")
    String getTestReportName();

    @Key("testDataSheetName")
    String getTestDataSheetName();
}
