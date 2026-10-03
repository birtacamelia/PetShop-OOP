public class Vanzare {
     private Client client;
     private String data;
     private int cantitate;
     private Vandabil articol;

     public Vanzare(Client client,String data,int cantitate,Vandabil articol)
     {
         this.client=client;
         this.data=data;
         this.cantitate=cantitate;
         this.articol=articol;
     }

     public Client getClient()
     {
         return client;
     }

     public void setClient(Client client)
     {
         this.client=client;
     }

     public String getData()
     {
         return data;
     }

     public void setData(String data)
     {
         this.data=data;
     }

     public int getCantitate()
     {
         return cantitate;
     }
     public void setcantitate(int cantitate)
     {
         this.cantitate=cantitate;
     }
     public Vandabil getArticol()
     {
         return articol;
     }
     public void setArticol(Vandabil articol)
     {
         this.articol=articol;
     }

    public double getValoareTotala() {
        return articol.getPret()*cantitate;
    }

    @Override
    public String toString()
     {
         return "Vanzarea este: "+getClient()+", data="+data+", cantitate="+cantitate+", artocol="+articol+", total="+getValoareTotala();
     }
}
