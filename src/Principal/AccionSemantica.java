package Principal;

public abstract class AccionSemantica {

    protected static String buffer = "";

    public AccionSemantica(){
    }

    public abstract Token ejecutarAccion();

}
