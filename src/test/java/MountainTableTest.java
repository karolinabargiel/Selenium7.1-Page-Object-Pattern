import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.ColumnsOfMountainTablePage;
import pages.FormPage;
import pages.MountainTablePage;

public class MountainTableTest extends TestBase{
    MountainTablePage mountainTablePage;
    @BeforeEach
    public void testSetup() {
        mountainTablePage= new MountainTablePage(driver);
    }

    @ParameterizedTest
    @CsvSource({"http://www.seleniumui.moderntester.pl/table.php"})
    public void shouldGetInfoFromTable(String url){
        driver.get(url);
        for (ColumnsOfMountainTablePage mountain : mountainTablePage.getMountains()){
            mountain.printInfo();
        }

    }
}
