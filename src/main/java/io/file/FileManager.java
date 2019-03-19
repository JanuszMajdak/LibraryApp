package io.file;

import data.Library;

public interface FileManager {

    Library importData();

    void exportData(Library library);
}
