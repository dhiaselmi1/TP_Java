/**
 * Classe abstraite représentant un abonné téléphonique
 */
public abstract class Abonne implements Communication {
    protected int num;        // Numéro de téléphone
    protected double solde;   // Solde en dinars
    protected String nom;     // Nom de l'abonné

    /**
     * Constructeur initialisant tous les attributs
     * @param num Numéro de téléphone
     * @param solde Solde initial en dinars
     * @param nom Nom de l'abonné
     */
    public Abonne(int num, double solde, String nom) {
        this.num = num;
        this.solde = solde;
        this.nom = nom;
    }

    /**
     * Méthode abstraite pour obtenir le nom de l'opérateur
     * @return Nom de l'opérateur
     */
    public abstract String getOperateur();

    /**
     * Accesseur pour le nom
     * @return Nom de l'abonné
     */
    public String getNom() {
        return nom;
    }

    /**
     * Accesseur pour le solde
     * @return Solde actuel en dinars
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Méthode pour recharger le solde
     * @param m Montant à ajouter au solde
     */
    public void rechargerSolde(double m) {
        solde += m;
    }

    /**
     * Méthode pour afficher tous les attributs
     */
    public void identifier() {
        System.out.println("Nom: " + nom + ", Numéro: " + num + ", Solde: " + solde + " dinars, Opérateur: " + getOperateur());
    }

    // Constantes pour les tarifs
    private static final double COUT_SMS = 0.060; // 60 millimes = 0.060 dinars
    private static final double TARIF_MEME_OPERATEUR = 0.090; // 90 millimes = 0.090 dinars
    private static final double TARIF_AUTRE_OPERATEUR = 0.180; // 180 millimes = 0.180 dinars
    
    /**
     * Implémentation de la méthode envoyerSMS de l'interface Communication
     * @return true si l'envoi a réussi
     * @throws SoldeInsuffisantException si le solde est insuffisant
     */
    public boolean envoyerSMS() throws SoldeInsuffisantException {
        if (solde < COUT_SMS) {
            throw new SoldeInsuffisantException(2);
        }
        solde -= COUT_SMS;
        return true;
    }

    /**
     * Implémentation de la méthode appeler de l'interface Communication
     * @param contact Abonné à appeler
     * @param duree Durée de l'appel en minutes
     * @return true si l'appel a réussi
     * @throws SoldeInsuffisantException si le solde est insuffisant
     */
    public boolean appeler(Abonne contact, int duree) throws SoldeInsuffisantException {
        // Si même opérateur, tarif réduit, sinon tarif standard
        double tarifMinute = this.getOperateur().equals(contact.getOperateur()) ? 
                             TARIF_MEME_OPERATEUR : TARIF_AUTRE_OPERATEUR;
        
        double cout = tarifMinute * duree;
        if (solde < cout) {
            throw new SoldeInsuffisantException(1);
        }
        solde -= cout;
        return true;
    }
}