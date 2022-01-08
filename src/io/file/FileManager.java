package io.file;

import model.School;

public interface FileManager {
    School importData() throws Exception;
    void exportData(School school);
}
