

/**
 * Gestion complète d'une épreuve sportive avec ses participants
 * Cette classe centralise toutes les fonctionnalités liées à une compétition
 */
public class Epreuve {
    private String denomination;  // Nom de l'épreuve sportive
    private int max;             // Capacité maximale de participants
    private Athlete[] athletes;  // Liste des athlètes inscrits
    private int nbEffectif;     // Nombre actuel de participants
    private boolean termine;     // État de l'épreuve
    
    /**
     * Configure une nouvelle épreuve avec ses paramètres de base
     */
    public Epreuve(String denomination, int max) {
        this.denomination = denomination;
        this.max = max;
        this.athletes = new Athlete[max];
        this.nbEffectif = 0;
        this.termine = false;
    }
    
    /**
     * Génère un résumé détaillé de l'épreuve et de ses participants
     */
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
    
    /**
     * Inscrit un nouvel athlète si la capacité le permet
     */
    public void ajoutAthlete(Athlete a) {
        if (nbEffectif < max) {
            athletes[nbEffectif++] = a;
        }
    }
    
    /**
     * Marque l'épreuve comme terminée, empêchant toute modification ultérieure
     */
    public void terminer() {
        this.termine = true;
    }
    
    /**
     * Vérifie si l'épreuve est terminée
     */
    public boolean estTerminee() {
        return termine;
    }
    
    /**
     * Détermine la meilleure performance enregistrée
     */
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
    
    /**
     * Identifie l'athlète vainqueur de l'épreuve
     * Ne fonctionne que si l'épreuve est terminée
     */
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
    
    /**
     * Enregistre ou met à jour le résultat d'un athlète
     * Impossible si l'épreuve est terminée
     */
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
    
    /**
     * Récupère le résultat d'un athlète spécifique
     */
    public Resultat getResultat(int id) {
        for (int i = 0; i < nbEffectif; i++) {
            if (athletes[i].getId() == id) {
                return athletes[i].getResultat();
            }
        }
        return null;
    }
}