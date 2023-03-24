package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MountainTablePage {

    public MountainTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> tableRows;

    public List<ColumnsOfMountainTablePage> getMountains() {
        List<ColumnsOfMountainTablePage> mountains = new ArrayList<>();
        for (WebElement row: tableRows){
            mountains.add(new ColumnsOfMountainTablePage(row));
        }
        return mountains;

    }
}
