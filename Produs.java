public abstract class Produs implements Vandabil,Cautabil,Comparable<Produs>{
    private String id;
    private String categorie;
    private String denumire;
    private double pret;
    private int stoc;
    int popularitate;


    public Produs()
    {
        id="";
        categorie="";
        denumire="";
        pret=0;
        stoc=0;
    }
    public Produs(String id,String categorie,String denumire,double pret,int stoc)
    {
        this.id=id;
        this.categorie=categorie;
        this.denumire=denumire;
        this.pret=pret;
        this.stoc=stoc;
        this.popularitate=0;
    }
    @Override
    public boolean poateFiVandut(int cantitate)
    {
        if(stoc-cantitate>=0)
            return  true;
        else
            return false;
    }
    @Override
    public boolean cautare(String criteriu,String valoare)
    {
        if(criteriu.equalsIgnoreCase("denumire"))
            return denumire.equals(valoare);
        if(criteriu.equalsIgnoreCase("categorie"))
            return categorie.equals(valoare);

          return false;
    }
    public String getId() {
        return id;
    }

    @Override
    public void vinde(int cantitate)
    {
        stoc=stoc-cantitate;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCategorie()
    {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        if(pret>0)
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public  int getPopularitate()
    {
        return popularitate;
    }

    public void setPopularitate(int cantitate)
    {
        this.popularitate=this.popularitate+cantitate;
    }
    @Override
    public boolean esteDisponibil()
    {
        if(stoc>0)
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Produs p)
    {
        return this.denumire.compareTo(p.denumire);
    }
    @Override
    public String toString()
    {
        return "ID="+id+", denumire="+denumire+", pret="+pret+", stoc="+stoc+", popularitate="+getPopularitate();
    }
}
