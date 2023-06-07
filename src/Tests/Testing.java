package Tests;
import lab.WorkerWithCsv;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

/**
 * Тесты на проверку что данные присутствуют и на корректность некоторых данных
 */
public class Testing {
    @Test
    /**
     * Функция тестов
     */
    public void testCsv() {
        String csvFilePath = "data/foreign_names.csv";

        WorkerWithCsv csvReader = new WorkerWithCsv();
        List<List<String>> person = csvReader.workToCsv(csvFilePath, ';');

        Assertions.assertFalse(person.isEmpty(), "List should not be empty");

        Assertions.assertEquals("28290", person.get(10).get(0), "Incorrect data at row 1, column 1");
        Assertions.assertEquals("Aahan", person.get(1).get(1), "Incorrect data at row 1, column 2");
        Assertions.assertEquals("Female", person.get(2).get(2), "Incorrect data at row 1, column 3");
        Assertions.assertEquals("15.05.1970", person.get(1).get(3), "Incorrect data at row 1, column 4");
        Assertions.assertEquals("H", person.get(5).get(4), "Incorrect data at row 1, column 5");
        Assertions.assertEquals("1000", person.get(3).get(5), "Incorrect data at row 1, column 6");
    }
}
