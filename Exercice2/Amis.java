/**
 * Classe pour gérer une liste d'amis (abonnés)
 */
public class Amis {
    private Abonne[] liste;      // Tableau d'abonnés
    private int nbAbonnes;       // Nombre d'abonnés dans la liste

    /**
     * Constructeur avec taille maximale
     * @param tailleMax Nombre maximum d'abonnés dans la liste
     */
    public Amis(int tailleMax) {
        liste = new Abonne[tailleMax];
        nbAbonnes = 0;
    }

    /**
     * Affiche les informations de tous les abonnés
     */
    public void identifierTous() {
        for (int i = 0; i < nbAbonnes; i++) {
            liste[i].identifier();
        }
    }

    /**
     * Recharge le solde de tous les abonnés
     * @param m Montant à ajouter au solde de chaque abonné
     */
    public void rechargerTous(double m) {
        for (int i = 0; i < nbAbonnes; i++) {
            liste[i].rechargerSolde(m);
        }
    }

    /**
     * Ajoute un abonné s'il y a de l'espace disponible
     * @param a Abonné à ajouter à la liste
     */
    public void rejoindreAmis(Abonne a) {
        if (nbAbonnes < liste.length) {
            liste[nbAbonnes++] = a;
        }
    }

    /**
     * Méthode privée pour construire une liste de noms d'abonnés selon une condition
     * @param typeOperation 1 pour appel, 2 pour SMS
     * @param contact Abonné à contacter (null pour SMS)
     * @param duree Durée de l'appel (ignoré pour SMS)
     * @return Chaîne contenant les noms des abonnés répondant à la condition
     */
    private String construireListeAbonnes(int typeOperation, Abonne contact, int duree) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        
        for (int i = 0; i < nbAbonnes; i++) {
            try {
                boolean success = false;
                if (typeOperation == 1) {
                    // Cas d'un appel
                    success = liste[i].appeler(contact, duree);
                } else {
                    // Cas d'un SMS
                    success = liste[i].envoyerSMS();
                }
                
                if (success) {
                    if (found) sb.append(", ");
                    sb.append(liste[i].getNom());
                    found = true;
                }
            } catch (SoldeInsuffisantException e) {
                // Ignorer, passer simplement à l'abonné suivant
            }
        }
        
        if (!found) {
            try {
                throw new SoldeInsuffisantException(typeOperation);
            } catch (SoldeInsuffisantException e) {
                System.out.println(e.getMessage());
            }
            return "";
        }
        
        return sb.toString();
    }

    /**
     * Retourne les noms des abonnés qui peuvent appeler le contact pour une durée d
     * @param contact Abonné à appeler
     * @param d Durée de l'appel en minutes
     * @return Chaîne contenant les noms des abonnés pouvant appeler
     */
    public String quiAppelle(Abonne contact, int d) {
        return construireListeAbonnes(1, contact, d);
    }

    /**
     * Retourne les noms des abonnés qui peuvent envoyer un SMS
     * @return Chaîne contenant les noms des abonnés pouvant envoyer un SMS
     */
    public String quiEnvoieSMS() {
        return construireListeAbonnes(2, null, 0);
    }
}