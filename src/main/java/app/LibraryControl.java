package app;

import data.Library;
import io.DataReader;
import model.Book;
import model.Magazine;

public class LibraryControl {

    private DataReader dataReader = new DataReader();
    private Library library = new Library();


    public void controlLoop() {

        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
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


    private void printOptions() {
        System.out.println("Choose the option");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }


    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }


    private void printBooks() {
        library.printBooks();
    }

    private void printMagazines() {
        library.printMagazines();
    }


    private void exit() {
        System.out.println("I am closing the program. PA PA PA:)");

    }
}
