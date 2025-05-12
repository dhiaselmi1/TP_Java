/**
 * Gestionnaire de groupe d'amis pour les services de télécommunication
 * Facilite la gestion collective des abonnés et leurs interactions
 */
public class Amis {
    private Abonne[] liste;      // Membres du groupe
    private int nbAbonnes;       // Taille effective du groupe

    /**
     * Création d'un nouveau groupe avec capacité limitée
     */
    public Amis(int tailleMax) {
        liste = new Abonne[tailleMax];
        nbAbonnes = 0;
    }

    /**
     * Affichage des détails de tous les membres
     */
    public void identifierTous() {
        for (int i = 0; i < nbAbonnes; i++) {
            liste[i].identifier();
        }
    }

    /**
     * Recharge collective des soldes
     */
    public void rechargerTous(double m) {
        for (int i = 0; i < nbAbonnes; i++) {
            liste[i].rechargerSolde(m);
        }
    }

    /**
     * Intégration d'un nouveau membre
     */
    public void rejoindreAmis(Abonne a) {
        if (nbAbonnes < liste.length) {
            liste[nbAbonnes++] = a;
        }
    }

    /**
     * Utilitaire de vérification des capacités de communication
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
     * Identification des membres pouvant appeler
     */
    public String quiAppelle(Abonne contact, int d) {
        return construireListeAbonnes(1, contact, d);
    }

    /**
     * Identification des membres pouvant envoyer des SMS
     */
    public String quiEnvoieSMS() {
        return construireListeAbonnes(2, null, 0);
    }
}