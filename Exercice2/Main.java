public class Main {
    private static final int MAX_GROUPE = 4;
    private static final int TEMPS_APPEL = 3; // minutes
    private static final double MONTANT_CREDIT = 3.5; // dinars
    
    public static void main(String[] args) {
        Amis groupe = new Amis(MAX_GROUPE);

        // Création des abonnés avec des données différentes
        AbonneOrange sarah = new AbonneOrange(55123456, 0.035, "Sarah"); 
        AbonneOoredoo yasmine = new AbonneOoredoo(22987654, 0.080, "Yasmine"); 
        AbonneOrange malik = new AbonneOrange(55789012, 0.550, "Malik"); 

        // Constitution du groupe
        groupe.rejoindreAmis(sarah);
        groupe.rejoindreAmis(yasmine);
        groupe.rejoindreAmis(malik);

        // Création du contact principal
        AbonneOrange responsable = new AbonneOrange(55999888, 1.0, "Responsable");

        System.out.println("=== État Initial du Groupe ===");
        groupe.identifierTous();
        System.out.println();

        System.out.println("=== Test Messages ===");
        String contactsSMS = groupe.quiEnvoieSMS();
        System.out.println("Membres pouvant envoyer un SMS : " + contactsSMS);
        System.out.println();

        System.out.println("=== Test Appels (" + TEMPS_APPEL + " min) ===");
        String contactsAppel = groupe.quiAppelle(responsable, TEMPS_APPEL);
        System.out.println("Membres pouvant appeler pendant " + TEMPS_APPEL + " min : " + contactsAppel);
        System.out.println();

        if (contactsSMS.isEmpty() && contactsAppel.isEmpty()) {
            System.out.println("=== Recharge des Comptes ===");
            groupe.rechargerTous(MONTANT_CREDIT);
            System.out.println("Crédit ajouté : " + MONTANT_CREDIT + " dinars");
            System.out.println();

            System.out.println("=== État Après Recharge ===");
            groupe.identifierTous();
            System.out.println();

            System.out.println("=== Nouveau Test Messages ===");
            System.out.println("Membres pouvant envoyer un SMS : " + groupe.quiEnvoieSMS());
            System.out.println();

            System.out.println("=== Nouveau Test Appels ===");
            System.out.println("Membres pouvant appeler pendant " + TEMPS_APPEL + " min : " + 
                             groupe.quiAppelle(responsable, TEMPS_APPEL));
        }
        
        System.out.println("\n=== État Final du Groupe ===");
        groupe.identifierTous();
    }
}