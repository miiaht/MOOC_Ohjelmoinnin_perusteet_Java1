
public class Sailio {
    private int sisalto = 0;
    
    public Sailio() {
        this.sisalto = sisalto;
    }
    
    public int sisalto() {
         return this.sisalto; 
    } 
    public void asetaTyhjaksi() {
        this.sisalto = 0;
    }
    public void asetaTaydeksi() {
        this.sisalto = 100;
    }
    
    public void lisaa(int maara) {
        if (maara > 0 && maara < 100) {
            this.sisalto += maara;
            }
        if (maara >= 100 || this.sisalto >= 100) {
            this.sisalto = 100;
        }
    }
    
    public void poista(int maara) {
        if (maara > 0 && maara < this.sisalto) {
            this.sisalto -= maara;
            }
        else if (maara >=100 || maara > this.sisalto ) {
                this.sisalto  = 0;
                }    
    }    
       
    public String toString() {
          return  "" + this.sisalto + "/100"; 
    }        

}

