/**
 * Classe représentant un résultat basé sur un rang
 */
public class ResultatRang implements Resultat {
    private int rang; // Rang de l'athlète
    
    // Constructeur
    public ResultatRang(int rang) {
        this.rang = rang;
    }
    
    // Implémentation de toString() de l'interface Resultat
    public String toString() {
        return "Rang: " + rang;
    }
    
    // Implémentation de affiche() de l'interface Resultat
    public void affiche() {
        System.out.println(this.toString());
    }
    
    // Implémentation de compareTo() de l'interface Resultat
    public int compareTo(Resultat r) {
        if (!(r instanceof ResultatRang)) {
            throw new IllegalArgumentException("Peut seulement être comparé avec ResultatRang");
        }
        ResultatRang other = (ResultatRang) r;
        // Remarque: Un rang plus bas est meilleur (1ère place est meilleure que 2ème place)
        if (this.rang < other.rang) return 1;
        if (this.rang > other.rang) return -1;
        return 0;
    }
    
    // Accesseur pour rang
    public int getRang() {
        return rang;
    }
}