package org.example;

import java.util.*;

/**
 * Class décrivant un tour de Yahtzee a Yahtzee tour.
 */
public class YahtzeeTour {

    /**
     * Stocke les occurences des valeurs de dés par valeur de dé.
     */
    private final Map<Integer, Integer> valeursEtOccurencesDes;
    /**
     * Stocke les valeurs ordonnées des dés.
     */
    private final List<Integer> valeursOrdonnees;

    /**
     * Créé une instance de Yahtzee tour.
     *
     * @param valeursDes la valeurs des dès non ordonnées
     */
    public YahtzeeTour(final Integer... valeursDes) {
        if (valeursDes == null || valeursDes.length != 5) {
            throw new IllegalArgumentException("Valeurs des dés incorrectes");
        }
        Arrays.sort(valeursDes); // ordonne les valeurs
        valeursEtOccurencesDes = new LinkedHashMap<>();
        for (Integer num : valeursDes) {
            if (valeursEtOccurencesDes.containsKey(num)) {
                valeursEtOccurencesDes.put(num, valeursEtOccurencesDes.get(num) + 1);
            } else {
                valeursEtOccurencesDes.put(num, 1);
            }
        }
        valeursOrdonnees = new ArrayList<>(valeursEtOccurencesDes.keySet());
    }

    /**
     * @return le nombre de valeurs différentes issu du lancement des dés
     */
    public int getNombreValeursDifferentesDes() {
        return valeursEtOccurencesDes.size();
    }

    /**
     * Retourne la liste ordonnée des valeurs obtenues (sans duplication).
     * Par exemple, pour le lancer (2,3,2,4,4), la liste obtenue est (2,3,4)
     *
     * @return La liste ordonnée
     */
    public List<Integer> getValeursOrdonnees() {
        return Collections.unmodifiableList(valeursOrdonnees);
    }

    /**
     *
     * @param valeurDes la valeur du dé pour laquelle on veut le nombre d'occurence
     * @return le nombre d'occurences de la valeur du dé
     */
    public int getNombreOccurencesPourValeurDes(int valeurDes) {
        Integer res = valeursEtOccurencesDes.get(valeurDes);
        return res != null ? res : 0;
    }

    /**
     * @return le score correspondant à la combinaison de dés
     */
    public int calculeScore() {
        int score = 0;
        if (isYahtzee()) { // c'est un yahtzee
            score = 50;
        } else if (isFull()) {
            score = 25;
        } else if (isPetiteSuite()) { // petite suite
            score = 30;
        } else if (valeurDeBrelan() != 0) {
            score = 3 * valeurDeBrelan();
        }
        return score;
    }

    /**
     * @return true si c'est un yahtzee
     */
    public boolean isYahtzee() {
        return getNombreValeursDifferentesDes() == 1;
    }

    /**
     * @return true si c'est un full
     */
    public boolean isFull() {
        if (getNombreValeursDifferentesDes() == 2) {
            int nbOccurencePremiereValeur = getNombreOccurencesPourValeurDes(getValeursOrdonnees().get(0));
            return nbOccurencePremiereValeur == 2 || nbOccurencePremiereValeur == 3;
        }
        return false;
    }

    /**
     * @return true si petite suite
     */
    public boolean isPetiteSuite() {
        if (getNombreValeursDifferentesDes() == 4 || getNombreValeursDifferentesDes() == 5) {
            // petite suite
            return getValeursOrdonnees().containsAll(Arrays.asList(1, 2, 3, 4))
                    || getValeursOrdonnees().containsAll(Arrays.asList(2, 3, 4, 5))
                    || getValeursOrdonnees().containsAll(Arrays.asList(3, 4, 5, 6));
        }
        return false;
    }

    /**
     *
     * @return la valeur de dé triplée si c'est un brelan, 0 sinon
     */
    public int valeurDeBrelan() {
        int val = 0;
        if (getNombreValeursDifferentesDes() == 3) {
            for (int vali : getValeursOrdonnees()) {
                if (getNombreOccurencesPourValeurDes(vali) == 3) {
                    val = vali;
                }
            }
        }
        return val;
    }
}
