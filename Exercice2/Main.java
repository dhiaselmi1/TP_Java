/**
 * Classe principale pour tester les fonctionnalités de communication
 */
public class Main {
    // Constantes pour les valeurs monétaires et durées
    private static final int TAILLE_MAX_AMIS = 3;
    private static final int DUREE_APPEL = 5; // minutes
    private static final double MONTANT_RECHARGE = 5.0; // dinars
    
    public static void main(String[] args) {
        // Création d'une liste d'amis avec une taille maximale définie
        Amis amis = new Amis(TAILLE_MAX_AMIS);

        // Création des abonnés selon le tableau spécifié
        AbonneOrange sonia = new AbonneOrange(55111222, 0.045, "Sonia"); // 45 millimes = 0.045 dinars
        AbonneOoredoo jihene = new AbonneOoredoo(22111333, 0.060, "Jihene"); // 60 millimes = 0.060 dinars
        AbonneOrange houda = new AbonneOrange(55333222, 0.710, "Houda"); // 710 millimes = 0.710 dinars

        // Ajout des abonnés à la liste d'amis
        amis.rejoindreAmis(sonia);
        amis.rejoindreAmis(jihene);
        amis.rejoindreAmis(houda);

        // Création de l'abonné encadrant
        AbonneOrange encadrant = new AbonneOrange(55444555, 0.5, "Encadrant");

        // Affichage des informations initiales
        System.out.println("=== Informations initiales des abonnés ===");
        amis.identifierTous();
        System.out.println();

        // Test d'envoi de SMS à l'encadrant
        System.out.println("=== Test d'envoi de SMS à l'encadrant ===");
        String abonnesSMS = amis.quiEnvoieSMS();
        System.out.println("Abonnés qui peuvent envoyer un SMS : " + abonnesSMS);
        System.out.println();

        // Test d'appel à l'encadrant pendant 5 minutes
        System.out.println("=== Test d'appel à l'encadrant pendant 5 minutes ===");
        String abonnesAppel = amis.quiAppelle(encadrant, DUREE_APPEL);
        System.out.println("Abonnés qui peuvent appeler l'encadrant pendant " + DUREE_APPEL + " min : " + abonnesAppel);
        System.out.println();

        // Vérifier si personne ne peut contacter l'encadrant
        if (abonnesSMS.isEmpty() && abonnesAppel.isEmpty()) {
            // Recharge du solde pour tous les abonnés
            System.out.println("=== Recharge du solde pour tous les abonnés ===");
            amis.rechargerTous(MONTANT_RECHARGE);
            System.out.println("Tous les abonnés ont été rechargés de " + MONTANT_RECHARGE + " dinars.");
            System.out.println();

            // Affichage des informations après recharge
            System.out.println("=== Informations après recharge ===");
            amis.identifierTous();
            System.out.println();

            // Nouveau test d'envoi de SMS après recharge
            System.out.println("=== Nouveau test d'envoi de SMS après recharge ===");
            System.out.println("Abonnés qui peuvent envoyer un SMS : " + amis.quiEnvoieSMS());
            System.out.println();

            // Nouveau test d'appel après recharge
            System.out.println("=== Nouveau test d'appel après recharge ===");
            System.out.println("Abonnés qui peuvent appeler l'encadrant pendant " + DUREE_APPEL + " min : " + amis.quiAppelle(encadrant, DUREE_APPEL));
            System.out.println();
        }
        
        // Affichage des informations finales des abonnés
        System.out.println("=== Informations finales des abonnés ===");
        amis.identifierTous();
        System.out.println();
    }
}