/**
 * Classe représentant un abonné Orange
 */
public class AbonneOrange extends Abonne {
    // Constantes
    private static final String NOM_OPERATEUR = "Orange";
    private static final String PREFIXE_OPERATEUR = "5";
    private static final String OPERATEUR_INCONNU = "Inconnu";
    
    /**
     * Constructeur d'un abonné Orange
     * @param num Numéro de téléphone
     * @param solde Solde initial en dinars
     * @param nom Nom de l'abonné
     */
    public AbonneOrange(int num, double solde, String nom) {
        super(num, solde, nom);
    }

    /**
     * Retourne "Orange" si le numéro commence par 5, sinon "Inconnu"
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