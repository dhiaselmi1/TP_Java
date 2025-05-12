/**
 * Spécialisation pour les abonnés du réseau Orange
 * Gère les spécificités des services Orange
 */
public class AbonneOrange extends Abonne {
    private static final String NOM_OPERATEUR = "Orange";
    private static final String PREFIXE_OPERATEUR = "5";
    private static final String OPERATEUR_INCONNU = "Inconnu";
    
    /**
     * Création d'un nouvel abonné Orange
     */
    public AbonneOrange(int num, double solde, String nom) {
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