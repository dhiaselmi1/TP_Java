/**
 * Exception levée lorsque le solde est insuffisant pour effectuer une opération
 */
public class SoldeInsuffisantException extends Exception {
    /**
     * Constructeur avec choix du type de message
     * @param choix 1 pour un appel, 2 pour un SMS
     */
    public SoldeInsuffisantException(int choix) {
        super(choix == 1 ?
            "Solde insuffisant pour passer cet appel ! Veuillez recharger vos soldes" :
            "Solde insuffisant pour envoyer le message ! Veuillez recharger vos soldes");
    }
}