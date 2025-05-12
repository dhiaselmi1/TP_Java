/**
 * Interface pour les actions de communication
 */
public interface Communication {
    /**
     * Envoie un SMS
     * @return true si l'envoi a réussi
     * @throws SoldeInsuffisantException si le solde est insuffisant
     */
    public boolean envoyerSMS() throws SoldeInsuffisantException;
    /**
     * Effectue un appel téléphonique
     * @param contact Abonné à appeler
     * @param duree Durée de l'appel en minutes
     * @return true si l'appel a réussi
     * @throws SoldeInsuffisantException si le solde est insuffisant
     */
    public boolean appeler(Abonne contact, int duree) throws SoldeInsuffisantException;
}