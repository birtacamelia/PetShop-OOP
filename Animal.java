public abstract class Animal implements Vandabil,Cautabil,Comparable<Animal> {
    private String id;
    private String rasa;
    private String specie;
    private int varsta;
    private double pret;
    private boolean disponibil;
    int numarExemplare;

    public Animal()
    {
        id="";
        rasa="";
        specie="";
        varsta=0;
        pret=0;
        disponibil=true;
    }

    public Animal(String id,String rasa,String specie,int varsta,double pret,boolean disponibil,int numarExemplare)
    {
        this.id=id;
        this.rasa=rasa;
        this.specie=specie;
        this.varsta=varsta;
        this.pret=pret;
        this.disponibil=disponibil;
        this.numarExemplare=numarExemplare;
    }

    @Override
    public boolean poateFiVandut(int cantitate)
    {
        if(numarExemplare-cantitate>=0 && disponibil==true)
        return true;
        else
            return  false;
    }
    @Override
    public void vinde(int cantitate)
    {
        this.numarExemplare=this.numarExemplare-cantitate;
        if(numarExemplare==0)
        this.disponibil=false;
    }

    @Override
    public boolean cautare(String criteriu,String valoare)
    {
        if(criteriu.equalsIgnoreCase("specie"))
            return specie.equals(valoare);
        if(criteriu.equalsIgnoreCase("rasa"))
            return rasa.equals(valoare);
        if(criteriu.equalsIgnoreCase("pret"))
        {
            double pretCautat=Double.parseDouble(valoare);
            return pret==pretCautat;
        }
        return  false;


    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public double getPret() {
        return pret;
    }

    public int getVarsta()
    {
        return varsta;
    }

    public void setVarsta(int varsta)
    {
        if(varsta>0)
            this.varsta=varsta;
    }
    public void setPret(double pret) {
        if(pret>0)
        this.pret = pret;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }

    public int getNumarExemplare()
    {
        return numarExemplare;
    }
    @Override
    public boolean esteDisponibil() {
        return disponibil;
    }

    @Override
    public int compareTo(Animal a)
    {
        if(this.pret<a.pret)
            return -1;
        else if (this.pret==a.pret) {
            return 0;
        }
        else
            return 1;
    }
    @Override
    public String toString()
    {
        return "ID="+id+", specie="+specie+", rasa="+rasa+", varsta="+varsta+", pret="+pret+", disponibil="+disponibil
                ;
    }
}
