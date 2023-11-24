package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahtzeeScoreStepdefs {

    private YahtzeeTour yahtzeeTour;

    @Given("un utilisateur obtenant [{int};{int};{int};{int};{int}] en jetant ses dés")
    public void unUtilisateurObtenantEnJetantSesDés(int val1, int val2, int val3, int val4, int val5) {
        yahtzeeTour = new YahtzeeTour(val1, val2, val3, val4, val5);
    }

    @Then("le score obtenu est {int}")
    public void leScoreObtenuEst(int score) {
        assertEquals(score,yahtzeeTour.calculeScore());
    }


}
