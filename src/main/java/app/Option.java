package app;

public enum Option {

    EXIT(0, "Exit from programme"),
    ADD_BOOK(1, "Adding a book"),
    ADD_MAGAZINE(2, "Adding magazine/newspaper"),
    PRINT_BOOKS(3, "Displaying the available books"),
    PRINT_MAGAZINES(4, "Displaying the available magazines/newspapers");

    private int value;
    private String description;


    Option(int value, String description) {
        this.value = value;
        this.description = description;
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

    static Option createFromInt(int option) {
        return Option.values()[option];
    }

}
