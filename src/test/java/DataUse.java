import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static com.codeborne.selenide.Selenide.$;

public class DataUse {
    private static Faker faker = new Faker(new Locale("ru"));
    private static String firstName = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String phone = faker.phoneNumber().cellPhone();
    private static String city = faker.address().cityName();

    public static Faker getFaker() {
        return faker;
    }

    public static String getName() {
        return firstName+lastName;
    }


    public static String getPhone() {
        return phone;
    }

    public static String getCity() {
        return city;
    }
    public static String getFormattedFutureDate (){
        LocalDate today = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dayToMeet = today.format(formatter);
        return dayToMeet;
    }
    public static void cleanUp(){
        $("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public static String getNewDate(){
        LocalDate todayNew = LocalDate.now().plusDays(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dayNew = todayNew.format(formatter);
        return dayNew;
    }
}
