package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class YahtzeeTourTest {

    @Test
    void yahtzeeTourConstruction_testNombreIncorrectArguments() {
        // expected : une exception est levée quand on ne fournit pas le bon nombre de valeurs
        assertThrows(IllegalArgumentException.class, () -> new YahtzeeTour(1,2,3));
        assertThrows(IllegalArgumentException.class, () -> new YahtzeeTour(1,2,3,3,3,6));
        assertThrows(IllegalArgumentException.class, YahtzeeTour::new);
        assertThrows(IllegalArgumentException.class, () -> new YahtzeeTour((Integer) null));
        assertThrows(IllegalArgumentException.class, () -> new YahtzeeTour((Integer[]) null));
    }

    @Test
    void getNombreValeursDifferentesDes_testCasNominaux() {
        // given a YahtzeeTour avec 5 valeurs différentes
        YahtzeeTour yahtzeeTour = new YahtzeeTour(1, 2, 5, 4, 3);
        // expected : le nombre de valeurs différentes est 5
        assertEquals(5, yahtzeeTour.getNombreValeursDifferentesDes());

        // given a YahtzeeTour avec 4 valeurs différentes
        yahtzeeTour = new YahtzeeTour(1, 2, 5, 2, 3);
        // expected : le nombre de valeurs différentes est 4
        assertEquals(4, yahtzeeTour.getNombreValeursDifferentesDes());

        // given a YahtzeeTour avec 3 valeurs différentes
        yahtzeeTour = new YahtzeeTour(1, 2, 5, 2, 5);
        // expected : le nombre de valeurs différentes est 4
        assertEquals(3, yahtzeeTour.getNombreValeursDifferentesDes());

        // given a YahtzeeTour avec 4 valeurs différentes
        yahtzeeTour = new YahtzeeTour(1, 2, 1, 2, 1);
        // expected : le nombre de valeurs différentes est 2
        assertEquals(2, yahtzeeTour.getNombreValeursDifferentesDes());

        // given a YahtzeeTour avec 4 valeurs différentes
        yahtzeeTour = new YahtzeeTour(2, 2, 2, 2, 2);
        // expected : le nombre de valeurs différentes est 2
        assertEquals(1, yahtzeeTour.getNombreValeursDifferentesDes());
    }

    @Test
    void getValeursOrdonnees_testsCasNominaux() {
        // given a YahtzeeTour avec 5 valeurs différentes
        YahtzeeTour yahtzeeTour = new YahtzeeTour(1, 2, 5, 4, 3);
        // expected : la liste est ordonnées avec les 5 valeurs
        assertEquals(Arrays.asList(1,2,3,4,5), yahtzeeTour.getValeursOrdonnees());
        // given a YahtzeeTour avec 3 valeurs différentes
        yahtzeeTour = new YahtzeeTour(1, 2, 5, 2, 1);
        // expected : la liste est ordonnées avec les 3 valeurs
        assertEquals(Arrays.asList(1,2,5), yahtzeeTour.getValeursOrdonnees());
        // given a YahtzeeTour avec 1 valeur
        yahtzeeTour = new YahtzeeTour(2, 2, 2, 2, 2);
        // expected : la liste contient la valeur
        assertEquals(Collections.singletonList(2), yahtzeeTour.getValeursOrdonnees());
    }

    @Test
    void getNombreOccurencesPourValeurDes_CasNominaux() {
        // given a YahtzeeTour avec 5 valeurs différentes
        YahtzeeTour yahtzeeTour = new YahtzeeTour(1, 2, 5, 4, 3);
        // expected: le nombre d'occurence est 1 pour n'importe qu'elle valeur du lancer
        assertEquals(1, yahtzeeTour.getNombreOccurencesPourValeurDes(5));
        assertEquals(1, yahtzeeTour.getNombreOccurencesPourValeurDes(2));
        assertEquals(1, yahtzeeTour.getNombreOccurencesPourValeurDes(3));
        assertEquals(1, yahtzeeTour.getNombreOccurencesPourValeurDes(1));
        // expected: 0 pour la valeur qui n'est pas dans le lancer
        assertEquals(0, yahtzeeTour.getNombreOccurencesPourValeurDes(6));

        // given a YahtzeeTour avec 2 valeurs différentes
        yahtzeeTour = new YahtzeeTour(5, 5, 1, 1, 1);
        // expected: le nombre d'occurence est 2 ou 3 pour les valeurs du lancer
        assertEquals(2, yahtzeeTour.getNombreOccurencesPourValeurDes(5));
        assertEquals(3, yahtzeeTour.getNombreOccurencesPourValeurDes(1));
        // expected: 0 pour une valeur qui n'est pas dans le lancer
        assertEquals(0, yahtzeeTour.getNombreOccurencesPourValeurDes(2));
    }

    @Test
    void calculeScore_Yahtzee() {
        // given: un yahtzee
        YahtzeeTour yahtzeeTour = new YahtzeeTour(2, 2, 2, 2, 2);
        // expected score = 50
        assertEquals(50, yahtzeeTour.calculeScore());

        // given: un yahtzee
        yahtzeeTour = new YahtzeeTour(6, 6, 6, 6, 6);
        // expected score = 50
        assertEquals(50, yahtzeeTour.calculeScore());
    }

    @Test
    void calculeScore_Full() {
        // given: un Full
        YahtzeeTour yahtzeeTour = new YahtzeeTour(2, 1, 2, 1, 2);
        // expected score =
        assertEquals(25, yahtzeeTour.calculeScore());

        // given: un Full
        yahtzeeTour = new YahtzeeTour(6, 6, 4, 4, 4);
        // expected score = 25
        assertEquals(25, yahtzeeTour.calculeScore());
    }

    @Test
    void calculeScore_PetiteSuite() {
        // given: une petite suite
        YahtzeeTour yahtzeeTour = new YahtzeeTour(6, 4, 3, 1, 2);
        // expected score =
        assertEquals(30, yahtzeeTour.calculeScore());

        // given: une petite suite
        yahtzeeTour = new YahtzeeTour(2, 4, 5, 3, 2);
        // expected score = 25
        assertEquals(30, yahtzeeTour.calculeScore());
    }

}