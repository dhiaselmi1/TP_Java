

/**
 * Classe représentant une épreuve sportive
 */
public class Epreuve {
    private String denomination;
    private int max;
    private Athlete[] athletes;
    private int nbEffectif;
    private boolean termine;
    
    // Constructeur
    public Epreuve(String denomination, int max) {
        this.denomination = denomination;
        this.max = max;
        this.athletes = new Athlete[max];
        this.nbEffectif = 0;
        this.termine = false;
    }
    
    // Méthode pour obtenir les informations de l'épreuve
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Epreuve: ").append(denomination);
        sb.append("\nStatut: ").append(termine ? "Terminée" : "En cours");
        sb.append("\nParticipants:");
        for (int i = 0; i < nbEffectif; i++) {
            sb.append("\n- ").append(athletes[i].getNon());
        }
        return sb.toString();
    }
    
    // Méthode pour ajouter un athlète
    public void ajoutAthlete(Athlete a) {
        if (nbEffectif < max) {
            athletes[nbEffectif++] = a;
        }
    }
    
    // Méthode pour terminer l'épreuve
    public void terminer() {
        this.termine = true;
    }
    
    // Méthode pour vérifier si l'épreuve est terminée
    public boolean estTerminee() {
        return termine;
    }
    
    // Méthode pour obtenir le record olympique
    public Resultat getRecordOlympique() {
        if (nbEffectif == 0) return null;
        
        Resultat best = athletes[0].getResultat();
        for (int i = 1; i < nbEffectif; i++) {
            Resultat current = athletes[i].getResultat();
            if (current != null && current.compareTo(best) > 0) {
                best = current;
            }
        }
        return best;
    }
    
    // Méthode pour obtenir le vainqueur
    public Athlete getVinqueur() {
        if (!termine || nbEffectif == 0) return null;
        
        Athlete winner = athletes[0];
        Resultat bestResult = winner.getResultat();
        
        for (int i = 1; i < nbEffectif; i++) {
            Resultat current = athletes[i].getResultat();
            if (current != null && current.compareTo(bestResult) > 0) {
                winner = athletes[i];
                bestResult = current;
            }
        }
        return winner;
    }
    
    // Méthode pour définir ou mettre à jour le résultat d'un athlète
    public void fixeResultat(int id, Resultat r) throws IllegalStateException {
        if (termine) {
            throw new IllegalStateException();
        }
        
        for (int i = 0; i < nbEffectif; i++) {
            if (athletes[i].getId() == id) {
                athletes[i].setResultat(r);
                return;
            }
        }
    }
    
    // Méthode pour obtenir le résultat d'un athlète
    public Resultat getResultat(int id) {
        for (int i = 0; i < nbEffectif; i++) {
            if (athletes[i].getId() == id) {
                return athletes[i].getResultat();
            }
        }
        return null;
    }
}