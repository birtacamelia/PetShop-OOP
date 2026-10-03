import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class PetShop {
    private HashMap<String,Animal> animale=new HashMap<>();
    private HashMap<String,Produs> produse=new HashMap<>();
    private ArrayList<Client> clienti=new ArrayList<>();
    private ArrayList<Vanzare> vanzari=new ArrayList<>();

    public void addAnimal(Animal animal)
    {
        if(animal==null){
            System.out.println("Animal invalid");
            return;}

        if(animale.containsKey(animal.getId())==true)
            System.out.println("Animalul exista in PetShop");
        else
            animale.put(animal.getId(),animal);
    }

    public void eliminaAnimal(Animal animal)
    {
        if(animale.containsKey(animal.getId()))
        animale.remove(animal.getId());
        else
            System.out.println("Animalul nu exista in PetShop");
    }

    public void afisareAnimale()
    {
        for (Animal a: animale.values())
            System.out.println(a);
    }

    public void updateAnimal(String id,String specie, String rasa,int varsta,double pret,boolean disponibil)
    {
        Animal animal=animale.get(id);
        if(animal!=null)
        {
            animal.setSpecie(specie);
            animal.setRasa(rasa);
            animal.setVarsta(varsta);
            animal.setPret(pret);
            animal.setDisponibil(disponibil);
        }
    }
    public void afisareAnimaleDisponibile()
    {
       for(Animal a:animale.values())
       {
           if(a.esteDisponibil())
           {
               System.out.println(a);
           }
       }
    }

    public void addProdus(Produs produs)
    {
        if(produse.containsKey(produs.getId()))
        {
            System.out.println("Produsul a fost deja adaugat.");
        }
        else
            produse.put(produs.getId(),produs);
    }

    public void actualizareProdus(String id,int stoc,double pret)
    {
        Produs p=produse.get(id);
        if(p==null)
            System.out.println("Produsul nu exista ");
        else
        {
            p.setPret(pret);
            p.setStoc(stoc);
        }
    }

    public void afisareProduse()
    {
        for(Produs p: produse.values())
        {
            System.out.println(p);
        }
    }

    public void stocRedus()
    {
        System.out.println("Atentie! Urmatoarele produse au stocul redus.");
        for(Produs p: produse.values())
        {
            if(p.getStoc()<=5)
                System.out.println(p.getDenumire());
        }
    }

    public void inregistrareClient(Client client)
    {
        if(client==null){
            System.out.println("Client invalid");
            return;}
        for(Client c:clienti)
        {
            if(c.getId().equals(client.getId())){
                System.out.println("Clientul exista deja");
                return;}
        }

        clienti.add(client);
    }

    public void afisareInformatiiClient(Client client) throws ClientInexistentException
    {
        for(Client c:clienti)
        {
            if(c.getId().equals(client.getId())){
                System.out.println(c);
                return;}
        }
        throw new ClientInexistentException("Clientul "+client+" nu exista");
    }

    public void afisareIstoricCumparaturi(Client client)
    {
        boolean gasit=false;
        for(Vanzare v: vanzari)
        {
            if(v.getClient().getId().equals(client.getId())){
                System.out.println(v);
                gasit=true;}

        }
        if(gasit==false)
        System.out.println("Clientul nu a cumparat nimic");
    }

    public void vanzareArticol(Vanzare v) throws AnimalIndisponibilException,ProdusIndisponibilException,VanzareInvalidaException
    {
        if(v==null || v.getCantitate()<=0|| v.getArticol()==null)
        {
            throw new VanzareInvalidaException("Vanzarea nu este valida");
        }
        if(v.getArticol().poateFiVandut(v.getCantitate()))
        {
            v.getArticol().vinde(v.getCantitate());
            vanzari.add(v);
            v.getClient().setNumarAchizitii();
            if (v.getArticol() instanceof Produs) {
                Produs p = (Produs) v.getArticol();
                p.setPopularitate(v.getCantitate());
        }}
        else
            if(v.getArticol() instanceof Animal)
                throw new AnimalIndisponibilException("Animalul "+v.getArticol()+" nu poate fi vandut");
            else
           throw new ProdusIndisponibilException("Produsul "+v.getArticol()+" nu poate fi vandut");
    }

    public void evidentiareTranzactii()
    {
        for(Vanzare v:vanzari)
        {
            System.out.println(v);
        }
    }

    public void cautaAnimale(String criteriu, String valoare) {
        boolean gasit=false;
        for (Animal a : animale.values()) {
            if (a.cautare(criteriu, valoare)) {
                System.out.println("S-a gasit animalul "+a);
                gasit=true;
            }
        }
        if(gasit==false)
            System.out.println("Nu s-a gasit animalul cautat");
    }

    public void cautareProdus(String criteriu,String valoare)
    {
        boolean gasit=false;
        for(Produs p: produse.values())
        {
            if(p.cautare(criteriu,valoare)){
                System.out.println("S-a gasit produsul "+p);
            gasit=true;}
        }
        if(gasit==false)
            System.out.println("Nu s-a gasit produsul cautat");
    }

    public ArrayList<Vandabil> animaleSiProduseDisponibile()
    {
        ArrayList<Vandabil> disponibile=new ArrayList<>();
        for(Animal a: animale.values())
        {
            if(a.esteDisponibil())
                disponibile.add(a);
        }

        for (Produs p: produse.values())
        {
            if(p.esteDisponibil())
                disponibile.add(p);
        }

        return disponibile;
    }

    public void afisareListaDisponibila(ArrayList<Vandabil> disponibile)
    {
        for(Vandabil v:disponibile)
            System.out.println(v);
    }

    public void afisareProduseStocRedus()
    {
        System.out.println("Produse cu stoc redus:");
        for (Produs p : produse.values()) {
            if (p.getStoc() <= 5)
                System.out.println(p);
        }
    }
    public double valoareaTotalaVanzari()
    {
        double total=0;
        for(Vanzare v:vanzari)
            total=total+v.getValoareTotala();

        return total;
    }

    public void clientiiCuCeleMaiMulteAchizitii()
    {
        System.out.println("Clientii cu cele mai multe achizitii sunt ");
        int max=0;
        for(Client c: clienti)
        {
            if(c.getNumarAchizitii()>max)
                max=c.getNumarAchizitii();
        }

        for(Client c:clienti)
        {
            if(c.getNumarAchizitii()==max)
                System.out.println(c);
        }
    }

    public void sortareDupaPret()
    {
        ArrayList<Animal> sortareAnimale=new ArrayList<>(animale.values());
        Collections.sort(sortareAnimale);
        System.out.println("Animalele sortate dupa pret");
        for (Animal a:sortareAnimale)
            System.out.println(a);
    }
    public void sortareDupaDenumire()
    {
        System.out.println("Produsele sortate dupa denumire");
        ArrayList<Produs> sortareProduse=new ArrayList<>(produse.values());
        Collections.sort(sortareProduse);
        for(Produs p:sortareProduse)
            System.out.println(p);

    }

    public void sortareDupaStoc()
    {
        System.out.println("Produsele sortate dupa stoc:");
        ArrayList<Produs> sortareProduse=new ArrayList<>(produse.values());
        Collections.sort(sortareProduse,new ComparatorStoc());
        for(Produs p:sortareProduse)
            System.out.println(p);
    }

    public void sortareDupaPopularitate()
    {
        System.out.println("Produsele sortate dupa popularitate:");
        ArrayList<Produs> sortareProduse=new ArrayList<>(produse.values());
        Collections.sort(sortareProduse,new ComparatorPopularitate());
        for(Produs p:sortareProduse)
            System.out.println(p);
    }

    public HashMap<Animal,Integer> animaleDisponibileSiNumarulLor()
    {
        HashMap<Animal,Integer> disponibile=new HashMap<>();
        for (Animal a : animale.values()) {
            if (a.esteDisponibil()) {
                disponibile.put(a, a.getNumarExemplare());
            }
        }

        return disponibile;
    }

}
