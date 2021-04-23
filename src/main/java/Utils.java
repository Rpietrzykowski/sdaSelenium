import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utils {
    public void makeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile, new File("/Users/rpietrzykowski/IdeaProjects/sdaSelenium/screenshots/" + screenshotName + ".png"));
    }
}
