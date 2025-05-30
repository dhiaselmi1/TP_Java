/**
 * Cette classe représente un athlète participant à une compétition.
 * Elle contient les informations de base de l'athlète comme son identifiant,
 * son nom et ses résultats.
 */
public class Athlete {

    private int id ;
    private String non ;
    private Resultat resultat ;
    public Athlete(int id, String non ){
    this.id=id ;
    this. non = non ;
    resultat=null ;
    }
    
    public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }
    public String getNon() {
    return non;
    }
    public void setNon(String non) {
    this.non = non;
    }
    public Resultat getResultat() {
    return resultat;}
    
    public void setResultat(Resultat resultat) {
    this.resultat = resultat;}
}