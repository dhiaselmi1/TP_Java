/**
 * Classe représentant un résultat basé sur une distance
 */
public class ResultatDistance implements Resultat {
    private double distance; // Distance réalisée par l'athlète
    
    // Constructeur
    public ResultatDistance(double distance) {
        this.distance = distance;
    }
    
    // Implémentation de toString() de l'interface Resultat
    public String toString() {
        return String.format("%.2f m", distance);
    }
    
    // Implémentation de affiche() de l'interface Resultat
    public void affiche() {
        System.out.println(this.toString());
    }
    
    // Implémentation de compareTo() de l'interface Resultat
    public int compareTo(Resultat r) {
        if (!(r instanceof ResultatDistance)) {
            throw new IllegalArgumentException("Peut seulement être comparé avec ResultatDistance");
        }
        ResultatDistance other = (ResultatDistance) r;
        if (this.distance > other.distance) return 1;
        if (this.distance < other.distance) return -1;
        return 0;
    }
    
    // Accesseur pour distance
    public double getDistance() {
        return distance;
    }
}