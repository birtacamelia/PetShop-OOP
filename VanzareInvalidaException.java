public class VanzareInvalidaException extends Exception{
    public VanzareInvalidaException()
    {
        super("Vanzarea nu poate fi realizata");
    }

    public VanzareInvalidaException(String msj)
    {
        super(msj);
    }
}
