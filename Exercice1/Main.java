

public class Main {
    public static void main(String[] args) {
        // Création des athlètes avec leurs résultats
        Athlete athlete1 = new Athlete(1, "Kylian Mbappé");
        athlete1.setResultat(new ResultatDistance(9.71)); // Temps fictif pour le 100m
        
        Athlete athlete2 = new Athlete(2, "Zinedine Zidane");
        athlete2.setResultat(new ResultatDistance(8.88)); // Distance fictive en mètres
        
        Athlete athlete3 = new Athlete(3, "Karim Benzema");
        athlete3.setResultat(new ResultatDistance(9.95)); 
        
        // Création d'une épreuve
        Epreuve competition = new Epreuve("Championnat de France 2024", 6);
        
        // Ajout des athlètes à l'épreuve
        competition.ajoutAthlete(athlete1);
        competition.ajoutAthlete(athlete2);
        competition.ajoutAthlete(athlete3);
        
        // Affichage des informations de l'épreuve
        System.out.println("=== Détails de la Compétition ===");
        System.out.println(competition);
        
        // Modification d'un résultat
        try {
            competition.fixeResultat(2, new ResultatDistance(9.15));
            System.out.println("\nNouveau résultat de " + athlete2.getNon() + ": " + competition.getResultat(2));
        } catch (IllegalStateException e) {
            System.out.println("Erreur: Modification impossible - compétition terminée");
        }
        
        // Affichage du record
        System.out.println("\n=== Record actuel ===");
        Resultat record = competition.getRecordOlympique();
        if (record != null) {
            System.out.println("Record: " + record);
        } else {
            System.out.println("Aucun record enregistré.");
        }
        
        competition.terminer();
        System.out.println("\nStatut de la compétition: " + (competition.estTerminee() ? "Terminée" : "En cours"));
        
        try {
            competition.fixeResultat(1, new ResultatDistance(9.65));
        } catch (IllegalStateException e) {
            System.out.println("Erreur: Modification impossible - compétition terminée");
        }
        
        System.out.println("\n=== Résultats Finaux ===");
        Athlete vainqueur = competition.getVinqueur();
        if (vainqueur != null) {
            System.out.println("Champion: " + vainqueur.getNon() + " - Performance: " + vainqueur.getResultat());
        } else {
            System.out.println("Pas de champion désigné.");
        }
    }
}