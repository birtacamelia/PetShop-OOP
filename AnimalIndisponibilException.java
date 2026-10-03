public class AnimalIndisponibilException extends Exception{
    public AnimalIndisponibilException()
    {
        super("Animalul nu este disponibil pentru vanzare.");
    }
    public AnimalIndisponibilException(String msj){
        super(msj);
    }
}
