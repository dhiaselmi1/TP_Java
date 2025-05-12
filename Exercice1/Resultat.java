/**
 * Interface représentant un résultat obtenu par un athlète dans une épreuve
 */
public interface Resultat {
    public String toString() ;
    public void affiche() ;
    public int compareTo(Resultat r) ;
}