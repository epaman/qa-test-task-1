/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package qa.test.task;

import org.testng.annotations.*;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;

public class QATask {
    private static String username = System.getProperty("username", "login");
    private static String password = System.getProperty("password", "pass");

    @BeforeClass
    public void beforeClass() {
        timeout = 20000;
        browserSize ="1200x750";
    }

    @Test public void widgetCreateRenameDelete() {
        // логин в личный кабинет
        open("https://login.sendpulse.com/login/");
        $("#login").val(username).pressTab();
        $("#password").val(password).pressEnter();

        // переход в раздел чат-ботов
        $(by("href","/messengers/")).click();

        // переход в подраздел "Виджеты подписки"
        $(byText("Виджеты подписки")).click();

        // создать виджет
        $(by("href","/messengers/widgets/new/")).click();
        $(".edit-mode").$(byText("Далее")).click();
        $(byText("Сохранить и получить код")).click();
        $(byText("Готово")).click();

        // assert создания
        // зайти в виджет, переименовать, сохранить
        // assert переименования
        $(withText("Плавающая")).should(exist).click();
        Random random = new Random();
        int num = random.nextInt(10);
        String a =
                $(by("type","text")).append(String.valueOf(num)).getText();
        $(byText("Сохранить и получить код")).click();
        $(byText("Готово")).click();
        $("a.ng-binding").shouldHave(text(a));

        // удалить виджет
        $(".dropdown.pull-right").click();
        $(byText("Удалить")).click();
        $(byText("Удалить")).click();
        $(withText("Готово!")).shouldBe(visible).waitUntil(disappears, 5000);
    }
}
