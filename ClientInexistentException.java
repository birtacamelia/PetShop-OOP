public class ClientInexistentException extends Exception{
    public ClientInexistentException()
    {
        super("Clientul nu exista");
    }
    public ClientInexistentException(String msj)
    {
        super(msj);
    }
}
