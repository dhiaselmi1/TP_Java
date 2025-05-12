

/**
 * Programme principal pour tester les fonctionnalités de gestion d'épreuves sportives
 */
public class Main {
    public static void main(String[] args) {
        // Création des athlètes avec leurs résultats
        Athlete athlete1 = new Athlete(1, "Usain Bolt");
        athlete1.setResultat(new ResultatDistance(9.58)); // Record du 100m en secondes
        
        Athlete athlete2 = new Athlete(2, "Carl Lewis");
        athlete2.setResultat(new ResultatDistance(8.95)); // Saut en longueur en mètres
        
        Athlete athlete3 = new Athlete(3, "Michael Phelps");
        // Utilisons le même type de résultat pour tous les athlètes
        athlete3.setResultat(new ResultatDistance(10.20)); // Une distance fictive pour l'exemple
        
        // Création d'une épreuve
        Epreuve competition = new Epreuve("Jeux Olympiques 2024", 5);
        
        // Ajout des athlètes à l'épreuve
        competition.ajoutAthlete(athlete1);
        competition.ajoutAthlete(athlete2);
        competition.ajoutAthlete(athlete3);
        
        // Affichage des informations de l'épreuve
        System.out.println("--- Informations de l'épreuve ---");
        System.out.println(competition);
        
        // Modification d'un résultat
        try {
            competition.fixeResultat(2, new ResultatDistance(9.10));
            System.out.println("\nRésultat de Carl Lewis mis à jour: " + competition.getResultat(2));
        } catch (IllegalStateException e) {
            System.out.println("Impossible de modifier le résultat: l'épreuve est terminée");
        }
        
        // Affichage du record olympique avant de terminer l'épreuve
        System.out.println("\n--- Record Olympique avant la fin ---");
        Resultat record = competition.getRecordOlympique();
        if (record != null) {
            System.out.println("Record: " + record);
        } else {
            System.out.println("Aucun record établi.");
        }
        
        // Terminer l'épreuve
        competition.terminer();
        System.out.println("\nL'épreuve est maintenant terminée: " + competition.estTerminee());
        
        // Tentative de modification après la fin (doit échouer)
        try {
            competition.fixeResultat(1, new ResultatDistance(9.50));
        } catch (IllegalStateException e) {
            System.out.println("Impossible de modifier le résultat: l'épreuve est terminée");
        }
        
        // Affichage du vainqueur
        System.out.println("\n--- Vainqueur ---");
        Athlete vainqueur = competition.getVinqueur();
        if (vainqueur != null) {
            System.out.println("Le vainqueur est: " + vainqueur.getNon() + " avec " + vainqueur.getResultat());
        } else {
            System.out.println("Aucun vainqueur déterminé.");
        }
    }
}