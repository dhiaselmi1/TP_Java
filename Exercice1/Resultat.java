/**
 * Interface définissant les méthodes essentielles pour la gestion des résultats sportifs
 * Cette interface permet de standardiser la manipulation des performances des athlètes
 */
public interface Resultat {
    public String toString();
    public void affiche();
    public int compareTo(Resultat r);
}