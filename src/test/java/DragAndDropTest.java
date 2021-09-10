import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @Test
    void dragAndDrop() {
        // Открываем https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Переносим прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Проверяем что у первой фигуры текст второй фигуры
        $("#column-a header").shouldHave(text("B"));
    }
}
