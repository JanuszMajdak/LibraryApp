package app;

import data.Library;
import exception.DataExportException;
import exception.DataImportException;
import exception.InvalidDataException;
import exception.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import io.file.FileManager;
import io.file.FileManagerBuilder;
import model.Book;
import model.Magazine;
import model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;

    private Library library = new Library();


    LibraryControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();

        try {
            library = fileManager.importData();
            printer.printLine("Imported data from file");
        } catch (DataImportException |InvalidDataException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Initiated the new base");
            library = new Library();
        }
    }


    public void controlLoop() {

        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("The choosen option not exists. Please choose numbers: 0-4");
            }
        } while (option != Option.EXIT);

    }


    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", give again");
            } catch (InputMismatchException ignored) {
                printer.printLine("You put the value, which is not a number, please give once again:");
            }
        }
        return option;
    }


    private void printOptions() {
        printer.printLine("Choose the option:");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }


    private void addBook() {

        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("It was not possible to create a book, not correct data were put.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("You achieved the limit of books capacity. It is not possible to add more books.");
        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addMagazine() {

        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("It was not possible to create a magazine, not correct data were put");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("You achieved the limit of magazines capacity. It is not possible to add more magazines.");
        }
    }


    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);

    }


    private void exit() {

        try {
            fileManager.exportData(library);
            printer.printLine("Export data was finished with success");
        } catch (DataExportException e) {
            printer.printLine(e.getMessage());

        }
        dataReader.close();
        printer.printLine("I am closing the program. PA PA PA:)");


    }

    private enum Option {

        EXIT(0, "Exit from programme"),
        ADD_BOOK(1, "Adding a book"),
        ADD_MAGAZINE(2, "Adding magazine/newspaper"),
        PRINT_BOOKS(3, "Displaying the available books"),
        PRINT_MAGAZINES(4, "Displaying the available magazines/newspapers");

        private int value;
        private String description;


        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }


        @Override
        public String toString() {
            return value + " - " + description;
        }

//convert int for Enum Option

        static Option createFromInt(int option) throws NoSuchOptionException {

            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Lack of option about id= " + option);
            }
        }

    }
}