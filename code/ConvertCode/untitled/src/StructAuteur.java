public class StructAuteur {
    public int nb;
    public String nom;
    public String prenom;

    public StructAuteur(int nb, String nom, String prenom) {
        this.nb = nb;
        this.nom = nom;
        this.prenom = prenom;
    }
    //UPDATE `auteurs` SET `nom`=null WHERE `nom`=null
    //UPDATE `auteurs` SET `prenom`=null WHERE `prenom`="null"
    public StructAuteur(int nb, String nom) {
        if(nom==null){
            this.nom = "null";
            this.prenom="null";
        }
        else{
            String[] sp=nom.split(",");
            this.nb = nb;
            this.nom = sp[0];
            if(sp.length>1){
                this.prenom=sp[1];
            }
            else {
                this.prenom="null";
            }
        }

    }

    public StructAuteur(String string) {
        this.nom=string;
        String[] sp=nom.split(",");
        this.nb = nb;
        this.nom = sp[0];
        if(sp.length>1){
            this.prenom=sp[1];
        }
        else {
            this.prenom="null";
        }
    }

    @Override
    public String toString() {
        return "StructAuteur: " +nb+" " +nom+" "+prenom;
    }
}
