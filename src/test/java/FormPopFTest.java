import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.FormPage;

import java.io.File;

public class FormPopFTest extends TestBase {
    FormPage formPage;

    @BeforeEach
    public void testSetup() {
        formPage = new FormPage(driver);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata.csv")
    public void shouldFillFormWithSuccess(String url, String firstName, String lastName, String email, int age, String filepath) {
        driver.get(url);
        formPage.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectRandomGender()
                .setAge(age)
                .selectRandomYearOfExperience()
                .selectProfessionAutTester()
                .selectRandomContinent()
                .selectSwitchCommand()
                .uploadFile(new File(filepath))
                .sendForm();

        Assertions.assertThat(formPage.getValidationMsg()).isEqualTo("Form send with success");

    }
}
