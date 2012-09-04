
public enum UserCommand {
    LIST_ALL_BOOKS("1"),
    REQUEST_A_BOOK("2"),
    CHECK_LIBRARY_NUMBER("3"),
    QUIT("q"),        
    LIST_ALL_MOVIES("4");
    
    private String code;

    private UserCommand(String  code) {
        this.code = code;
    }
    
    public void processCommand(){
        
    }
    
    
}
