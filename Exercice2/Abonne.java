/**
 * Classe fondamentale pour la gestion des abonnés mobiles
 * Implémente les fonctionnalités communes à tous les types d'abonnements
 */
public abstract class Abonne implements Communication {
    protected int num;        // Identifiant unique de la ligne
    protected double solde;   // Crédit disponible
    protected String nom;     // Identité du titulaire

    // Tarification standardisée
    private static final double COUT_SMS = 0.060;           // Tarif unique par SMS
    private static final double TARIF_MEME_OPERATEUR = 0.090;   // Tarif préférentiel/minute
    private static final double TARIF_AUTRE_OPERATEUR = 0.180;  // Tarif standard/minute

    /**
     * Initialisation complète d'un nouvel abonné
     */
    public Abonne(int num, double solde, String nom) {
        this.num = num;
        this.solde = solde;
        this.nom = nom;
    }

    /**
     * Identification de l'opérateur de l'abonné
     */
    public abstract String getOperateur();

    /**
     * Récupération de l'identité de l'abonné
     */
    public String getNom() {
        return nom;
    }

    /**
     * Consultation du crédit disponible
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Ajout de crédit sur la ligne
     */
    public void rechargerSolde(double m) {
        solde += m;
    }

    /**
     * Affichage des informations complètes de l'abonné
     */
    public void identifier() {
        System.out.println("Nom: " + nom + ", Numéro: " + num + ", Solde: " + solde + " dinars, Opérateur: " + getOperateur());
    }

    /**
     * Service d'envoi de SMS avec vérification du solde
     */
    public boolean envoyerSMS() throws SoldeInsuffisantException {
        if (solde < COUT_SMS) {
            throw new SoldeInsuffisantException(2);
        }
        solde -= COUT_SMS;
        return true;
    }

    /**
     * Service d'appel avec calcul du coût selon l'opérateur
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