package lab;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для чтения и добавления в список информации из csv файла
 */
public class WorkerWithCsv {
    /**
     *
     * @param filePath - путь к файлу
     * @param separator - символ разделения слов в файле
     * @return - список, хранящий данные из файла, либо пустой список, если было вызвано исключение
     */
    public List<List<String>> workToCsv(String filePath, char separator) {
        try (InputStream file = getClass().getClassLoader().getResourceAsStream(filePath);
             CSVReader reader = new CSVReader(new InputStreamReader(file, StandardCharsets.UTF_8), separator)) {
            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }
            List<List<String>> persons = new ArrayList<>();

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Добавляем строку данных в список
                persons.add(List.of(nextLine));
            }
            return persons;

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return new ArrayList<>();
    }
}