package com.genesys.framework.selenium.pom.guru99;

import com.genesys.framework.selenium.WebDriverFactory;
import com.genesys.framework.selenium.pom.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class Guru99NavBar extends BasePage {
//tagname[contains(text(), 'partial-text')]

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Selenium')]")
    private WebElement seleniumDropdown;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Tooltip')]")
    private WebElement tooltipOption;

    protected Guru99NavBar(final WebDriverFactory driverFactory) {
        super(driverFactory);
    }

    @Override
    public boolean isAt() {
        return false;
    }

    public Guru99NavBar clickToDropdown(final String dropdown) {
        switch (dropdown) {
            case "selenium" -> seleniumDropdown.click();
            //case ".." ->
            default -> {
                throw new RuntimeException(dropdown + " is not an option!");
            }
        }
        return this;
    }

    public Guru99NavBar clickToDropdownOption(final String option) {
        switch (option) {
            case "tooltip" -> tooltipOption.click();
            //case ".." ->
            default -> {
                throw new RuntimeException(option + " is not an option!");
            }
        }
        return this;
    }
}
