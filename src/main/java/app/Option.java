package app;

import exception.NoSuchOptionException;

public enum Option {

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


    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
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
