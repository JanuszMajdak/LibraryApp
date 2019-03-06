package app;

import data.Library;
import exception.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import model.Book;
import model.Magazine;
import model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);

    private Library library = new Library();


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
                    System.out.println("Please choose numbers: 0-4");
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
            library.addBook(book);
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
            library.addMagazine(magazine);
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
        printer.printLine("I am closing the program. PA PA PA:)");
        dataReader.close();

    }
}
