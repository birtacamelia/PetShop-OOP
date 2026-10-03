import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main (String[] args){
        Caine caine1=new Caine("01","Labrador",3,750,true,2);
        Caine caine2=new Caine("03","Husky",2,1100,true,3);
        Caine caine3=new Caine("04","Chihuahua",4,450,true,1);
        Pisica pisica1=new Pisica("07","Siameza",1,800,true,2);
        Pisica pisica2=new Pisica("02","Perseana",3,900,true,1);
        Pisica pisica3=new Pisica("08","British ShortHair",2,1100,true,2);
        Pasare pasare1=new Pasare("10","Papagal Perus",1,550,true,2);
        Pasare pasare2=new Pasare("11","Canar",2,300,false,0);
        Pasare pasare3=new Pasare("05","Cockatiel",1,400,false,0);

        PetShop petShop=new PetShop();

        petShop.addAnimal(caine1);
        petShop.addAnimal(caine3);
        petShop.addAnimal(pisica1);
        petShop.addAnimal(pisica2);
        petShop.addAnimal(pasare1);
        petShop.addAnimal(pasare2);
        petShop.addAnimal(caine2);
        petShop.addAnimal(pisica3);
        petShop.addAnimal(pasare3);
        petShop.afisareAnimale();

        System.out.println();
        petShop.afisareAnimaleDisponibile();

        System.out.println();

        petShop.eliminaAnimal(pisica2);
        petShop.afisareAnimale();

        System.out.println();
        caine3.vinde(1);
        petShop.afisareAnimale();

        System.out.println();
        petShop.updateAnimal("01","Pasare","Pionus",1,800,true);
        petShop.afisareAnimaleDisponibile();
        System.out.println();

        Medicamente medicament1=new Medicamente("01","Hepatiale Forte",68,12);
        Medicamente medicament2=new Medicamente("02","Condrovet Force HA",25.36,8);
        Medicamente medicament3=new Medicamente("05","Clavamox",29,6);
        Medicamente medicament4=new Medicamente("08","NexGard",138,5);
        Hrana hrana1=new Hrana("03","Tundra Dog Turkey Chicken",210,9);
        Hrana hrana2=new Hrana("11","Pachet Economic MIAU MIAU Hrana Uscata Pisica Adult",198,7);
        Hrana hrana3=new Hrana("04","Pachet Economic Hrana Umeda Pisica Adult MIAU MIAU",48,4);
        Accesorii accesoriu1=new Accesorii("06","Pat pentru caini si pisici",268.8,9);
        Accesorii accesoriu2=new Accesorii("07","Zgarda pentru caini",103,12);
        Accesorii accesoriu3=new Accesorii("09","Perie de ingrijire",50,8);
        Accesorii accesoriu4=new Accesorii("12","Jucarie pentru pisici",50,13);

        System.out.println();
        petShop.addProdus(medicament1);
        petShop.addProdus(medicament2);
        petShop.addProdus(hrana1);
        petShop.addProdus(hrana2);
        petShop.addProdus(accesoriu1);
        petShop.addProdus(accesoriu2);
        petShop.addProdus(medicament3);
        petShop.addProdus(medicament4);
        petShop.addProdus(hrana3);
        petShop.addProdus(accesoriu4);
        petShop.addProdus(accesoriu3);

        petShop.afisareProduse();

        System.out.println();
        petShop.actualizareProdus("01",10,40);
        petShop.afisareProduse();

        System.out.println();
        petShop.stocRedus();

        Client client1=new Client("01","Pop","Crina");
        Client client2=new Client("04","Ursa","Aura");
        Client client3=new Client("03","Berende","Mihai");
        Client client4=new Client("06","Balota","Maria");
        Client client5=new Client("02","Bosca","Lucas");
        Client client6=new Client("09","Candale","Andrei");
        Client client7=new Client("10","Sangeorzan","Laura");

        petShop.inregistrareClient(client1);
        petShop.inregistrareClient(client2);
        petShop.inregistrareClient(client3);
        petShop.inregistrareClient(client4);
        petShop.inregistrareClient(client5);
        petShop.inregistrareClient(client6);
        petShop.inregistrareClient(client7);

        System.out.println();
        try{
        petShop.afisareInformatiiClient(client1);}
        catch(ClientInexistentException e)
        {
            System.out.println("Exceptie "+e.getMessage());
        }

        System.out.println();
        petShop.afisareIstoricCumparaturi(client1);

        Vanzare vanzare1=new Vanzare(client1,"01.05.2025",3,medicament1);
        Vanzare vanzare2=new Vanzare(client2,"02.04.2025",2,hrana2);
        Vanzare vanzare3=new Vanzare(client1,"12.02.2025",1,caine1);
        Vanzare vanzare4=new Vanzare(client2,"03.01.2024",1,pisica3);
        Vanzare vanzare5=new Vanzare(client3,"07.03.2025",2,accesoriu1);
        Vanzare vanzare6=new Vanzare(client2,"11.02.2024",3,hrana1);
        Vanzare vanzare7=new Vanzare(client4,"03.05.2025",2,accesoriu2);
        Vanzare vanzare8=new Vanzare(client5,"12.04.2025",2,hrana2);
        Vanzare vanzare9=new Vanzare(client6,"15.02.2025",0,caine2);
        try {
            petShop.vanzareArticol(vanzare1);
            petShop.vanzareArticol(vanzare2);
            petShop.vanzareArticol(vanzare3);
            petShop.vanzareArticol(vanzare4);
            petShop.vanzareArticol(vanzare5);
            petShop.vanzareArticol(vanzare6);
            petShop.vanzareArticol(vanzare7);
            petShop.vanzareArticol(vanzare8);
            petShop.vanzareArticol(vanzare9);
        }
        catch (VanzareInvalidaException e)
        {
            System.out.println("Exceptie "+e.getMessage());
        }
        catch(AnimalIndisponibilException e)
        {
            System.out.println("Animalul nu poate fi vandut"+e.getMessage());
        }
        catch (ProdusIndisponibilException e)
        {
            System.out.println("Produsul nu poate fi vandut"+e.getMessage());
        }

        System.out.println();
        petShop.evidentiareTranzactii();

        System.out.println();
        petShop.afisareIstoricCumparaturi(client1);


        System.out.println();
        petShop.cautaAnimale("rasa","Siameza");
        petShop.cautareProdus("denumire","Zgarda pentru caini");


        System.out.println();
        ArrayList<Vandabil> disponibile=petShop.animaleSiProduseDisponibile();
        petShop.afisareListaDisponibila(disponibile);

        System.out.println();
        double total= petShop.valoareaTotalaVanzari();
        System.out.println("Valoarea totala a vanzarilor este "+total);

        System.out.println();
        petShop.clientiiCuCeleMaiMulteAchizitii();

        System.out.println();
        petShop.afisareProduseStocRedus();

        System.out.println();
        petShop.sortareDupaPret();
        System.out.println();

        petShop.sortareDupaDenumire();
        System.out.println();

        petShop.sortareDupaStoc();
        System.out.println();

        petShop.sortareDupaPopularitate();
        System.out.println();

        HashMap<Animal,Integer> animaleDisponibile=petShop.animaleDisponibileSiNumarulLor();
        System.out.println("Animalele disponibile si numarul lor:");
        for (Map.Entry<Animal, Integer> entry : animaleDisponibile.entrySet()) {
            System.out.println(entry.getKey() + " Exemplare disponibile: " + entry.getValue());
        }

    }
}
