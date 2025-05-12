/**
 * Classe représentant un abonné Ooredoo
 */
public class AbonneOoredoo extends Abonne {
    // Constantes
    private static final String NOM_OPERATEUR = "Ooredoo";
    private static final String PREFIXE_OPERATEUR = "2";
    private static final String OPERATEUR_INCONNU = "Inconnu";
    
    /**
     * Constructeur d'un abonné Ooredoo
     * @param num Numéro de téléphone
     * @param solde Solde initial en dinars
     * @param nom Nom de l'abonné
     */
    public AbonneOoredoo(int num, double solde, String nom) {
        super(num, solde, nom);
    }

    /**
     * Retourne "Ooredoo" si le numéro commence par 2, sinon "Inconnu"
     * @return Nom de l'opérateur
     */
    public String getOperateur() {
        String numStr = String.valueOf(num);
        if (numStr.startsWith(PREFIXE_OPERATEUR)) {
            return NOM_OPERATEUR;
        }
        return OPERATEUR_INCONNU;
    }
}