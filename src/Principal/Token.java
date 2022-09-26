package Principal;

public class Token {
    private int id;
    private String lexema;

    public Token(int id, String lexema){
        this.id = id;
        this.lexema = lexema;
    }

    public Token(int id) {
        this.id = id;
        this.lexema = null;
    }

    public int getId() {
        return id;
    }

    public String getLexema() {
        return lexema;
    }
}
