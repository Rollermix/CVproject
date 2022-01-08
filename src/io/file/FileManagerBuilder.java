package io.file;

import exception.NoSuchFileTypeException;
import io.DataReader;
import model.enumeration.FileType;

import java.nio.file.NoSuchFileException;


public class FileManagerBuilder {
    private DataReader dataReader;

    public FileManagerBuilder(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    public FileManager build() {
        System.out.println("Wpisz typ danych");
        FileType fileType = getFileType();
        switch (fileType)
        {
            case CSV :return new CsvFileManager();
            default:throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
        }

    }

    private FileType getFileType() {
        boolean typeOk = false;
        FileType result= null;
        do {
            printTypes();
            String type = dataReader.getString().toUpperCase();
            try {
                result=FileType.valueOf(type);
                typeOk=true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Nieobsługiwany typ danych");
            }
        }while (!typeOk);
        return result;
    }

    private void printTypes() {
        for (FileType value:FileType.values())
        {
            System.out.println(value.name());
        }
    }
}
