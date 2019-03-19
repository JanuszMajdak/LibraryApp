package io.file;

import exception.NoSuchFileTypeException;
import io.ConsolePrinter;
import io.DataReader;

public class FileManagerBuilder {

    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;

    }


    public FileManager build() {

        printer.printLine("Choose the format of data");
        FileType fileType = getFileType();

        switch (fileType){
            case SERIAL:
                return new SerializableFileManager();
                default:
                    throw new NoSuchFileTypeException("Not correct (handled) type of data");
        }

    }


    private FileType getFileType() {
        boolean typeOk = false;
        FileType result = null;

        do {
            printTypes();
            String type = reader.getString().toUpperCase();
try {
    result = FileType.valueOf(type);
    typeOk = true;
} catch (IllegalArgumentException e){
    printer.printLine("Not correct (handled) type of data, please choose once again.");
}

        } while (!typeOk);
        return result;
    }


    private void printTypes() {
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());
        }
    }


}
