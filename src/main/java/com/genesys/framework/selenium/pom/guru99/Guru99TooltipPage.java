package com.genesys.framework.selenium.pom.guru99;

import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class Guru99TooltipPage extends BasePage {

    @FindBy(how = How.ID, using = "download_now")
    private WebElement downloadNowButton;

    protected Guru99TooltipPage(final WebDriverFactory driverFactory) {
        super(driverFactory);
    }

    @Override
    public boolean isAt() {
        return downloadNowButton.isDisplayed();
    }

}
