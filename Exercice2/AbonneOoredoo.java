/**
 * Spécialisation pour les abonnés du réseau Ooredoo
 * Gère les spécificités des services Ooredoo
 */
public class AbonneOoredoo extends Abonne {
    private static final String NOM_OPERATEUR = "Ooredoo";
    private static final String PREFIXE_OPERATEUR = "2";
    private static final String OPERATEUR_INCONNU = "Inconnu";
    
    /**
     * Création d'un nouvel abonné Ooredoo
     */
    public AbonneOoredoo(int num, double solde, String nom) {
        super(num, solde, nom);
    }

    /**
     * Validation et identification du réseau
     */
    public String getOperateur() {
        String numStr = String.valueOf(num);
        if (numStr.startsWith(PREFIXE_OPERATEUR)) {
            return NOM_OPERATEUR;
        }
        return OPERATEUR_INCONNU;
    }
}