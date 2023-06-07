package lab;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvPath = "data/foreign_names.csv";

        WorkerWithCsv csvParser = new WorkerWithCsv();
        List<List<String>> persons = csvParser.workToCsv(csvPath, ';');

        for (int i = 1; i < persons.size(); i++) {
            List<String> person = persons.get(i);
            System.out.println(String.join("\t", person));
        }
    }
}

