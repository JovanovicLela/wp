package com.example.veb_d4.repository;
import lombok.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import static com.example.veb_d4.constants.Constants.*;

@Data
public class Repository {

    private static Map<String, Map<String, Integer>> repository;

    private Repository() {
    }

    // bill pugh singleton pattern
    private static class RepositoryHolder {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new ConcurrentHashMap<>();
            repository.put("Monday", new ConcurrentHashMap<String, Integer>());
            repository.put("Tuesday", new ConcurrentHashMap<String, Integer>());
            repository.put("Wednesday", new ConcurrentHashMap<String, Integer>());
            repository.put("Thursday", new ConcurrentHashMap<String, Integer>());
            repository.put("Friday", new ConcurrentHashMap<String, Integer>());

            try {
                initializeDataFromFile("Monday", MONDAY_FILE);
                initializeDataFromFile("Tuesday", TUESDAY_FILE);
                initializeDataFromFile("Wednesday", WEDNESDAY_FILE);
                initializeDataFromFile("Thursday", THURSDAY_FILE);
                initializeDataFromFile("Friday", FRIDAY_FILE);
            } catch (RepositoryInitializationException e) {
                e.printStackTrace();
            }
            return RepositoryHolder.INSTANCE;
        } else return RepositoryHolder.INSTANCE;

    }

    public static void initializeDataFromFile(String day, String filePath) throws RepositoryInitializationException {

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                repository.get(day).put(scanner.nextLine(), 0);
            }
        } catch (FileNotFoundException e) {
            throw new RepositoryInitializationException("Error initializing data from file: " + filePath, e);
        }
    }
    public Map<String, Integer> getDataForDay(String day) {
        return repository.get(day);
    }




}

