package io.file;

import exception.DataExportException;
import model.Person;
import model.School;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileManager implements FileManager{
    private static final String FILE_NAME = "School.csv";
    @Override
    public School importData() throws Exception {
        throw new Exception("Not implemented yet");
    }

    @Override
    public void exportData(School school) {
        Person[] persons = school.getPersons();
        try (
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (Person person : persons) {
                bufferedWriter.write(person.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
           throw new DataExportException("Błąd zapisu danych do pliku "+ FILE_NAME);
        }

    }
}
