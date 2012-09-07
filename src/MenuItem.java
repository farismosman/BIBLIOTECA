public enum MenuItem {
    LIST_ALL_BOOKS("1", "view a list all the books in the library", new ListAllBookCommand()),
    RESERVE_A_BOOK("2", "reserve a book", new RequestABookCommand()),
    CHECK_LIBRARY_NUMBER("3", "check your library number", new CheckLibraryNumberCommand()),
    LIST_ALL_MOVIES("4", "view movie records", new ListAllMoviesCommand());

    private final String id;
    private final String description;
    private Command command;

    private MenuItem(String id, String description, Command command) {
        this.id = id;
        this.description = description;
        this.command = command;
    }

    @Override
    public String toString() {
        return "To " + description + ", type " + id;
    }

    public static MenuItem getFromCode(String userInputId) {
        for (MenuItem menuItem : MenuItem.values()) {
            if (menuItem.id.equals(userInputId)) {
                return menuItem;
            }
        }
        return null;
    }

    public Command getUserCommand() {
        return command;
    }

    public String getId() {
        return id;
    }
}
