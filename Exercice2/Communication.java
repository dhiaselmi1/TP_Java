/**
 * Définition du contrat de communication pour les services téléphoniques
 * Cette interface standardise les opérations de base d'un service mobile
 */
public interface Communication {
    /**
     * Tente d'envoyer un SMS avec le solde actuel
     * @return Succès de l'opération
     * @throws SoldeInsuffisantException en cas de crédit insuffisant
     */
    public boolean envoyerSMS() throws SoldeInsuffisantException;

    /**
     * Établit une communication vocale avec un autre abonné
     * @param contact Destinataire de l'appel
     * @param duree Temps de communication prévu
     * @return Succès de l'opération
     * @throws SoldeInsuffisantException en cas de crédit insuffisant
     */
    public boolean appeler(Abonne contact, int duree) throws SoldeInsuffisantException;
}