public class ProdusIndisponibilException extends Exception{
    public ProdusIndisponibilException()
    {
        super("Produsul nu este disponibil pentru vanzare");
    }
    public ProdusIndisponibilException(String msj)
    {
        super(msj);
    }
}
