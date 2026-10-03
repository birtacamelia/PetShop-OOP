import java.util.ArrayList;

public class Client {
    public String id;
    private String nume;
    private String prenume;
    private int numarAchizitii;

    public Client(String id,String nume,String prenume )
    {
        this.id=id;
        this.nume=nume;
        this.prenume=prenume;
        this.numarAchizitii=0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getNumarAchizitii() {
        return numarAchizitii;
    }

    public void setNumarAchizitii() {
        this.numarAchizitii = this.numarAchizitii+1;
    }

    @Override
    public String toString()
    {
        return "ID="+id+", nume="+nume+", prenume="+prenume+", numar achizitii="+getNumarAchizitii();
    }
}
