/**
 * Implémentation concrète de l'interface Resultat pour le classement par rang
 * Cette classe gère les résultats basés sur le classement des athlètes
 */
public class ResultatRang implements Resultat {
    private int rang; // Position finale de l'athlète dans le classement
    
    /**
     * Initialise un nouveau résultat avec le rang spécifié
     * @param rang La position obtenue par l'athlète (1 = premier, etc.)
     */
    public ResultatRang(int rang) {
        this.rang = rang;
    }
    
    /**
     * Convertit le rang en chaîne de caractères formatée
     */
    public String toString() {
        return "Position finale: " + rang;
    }
    
    /**
     * Affiche le rang sur la sortie standard
     */
    public void affiche() {
        System.out.println(this.toString());
    }
    
    /**
     * Compare deux résultats entre eux
     * Un rang plus petit est considéré comme meilleur
     */
    public int compareTo(Resultat r) {
        if (!(r instanceof ResultatRang)) {
            throw new IllegalArgumentException("Comparaison impossible avec un type différent");
        }
        ResultatRang autre = (ResultatRang) r;
        if (this.rang < autre.rang) return 1;
        if (this.rang > autre.rang) return -1;
        return 0;
    }
    
    /**
     * Récupère la valeur du rang
     */
    public int getRang() {
        return rang;
    }
}