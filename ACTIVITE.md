# R4-02 Qualité de développement - Yahtzee

## 0. Modification du fichier README

Vous travaillez en binôme, un des membres du binôme doit modifier le fichier README avec vos noms, prénoms et groupe.

## Développement en TDD du calcul du score d'un tour de partie de Yahtzee

[Extrait de Wikipedia](https://fr.wikipedia.org/wiki/Yahtzee)

Pour jouer au Yahtzee, il faut cinq dés classiques à six faces.
Le jeu se déroule tour à tour. A leur tour, chaque joueur lance les cinq dés dans le but d'obtenir une figure 
(c'est-à-dire, un arrangement particulier des dés) permettant de marquer des points.

Les différentes figures d'une partie sont les suivantes :


| Figure       | Condition                                    | Score                           | Exemple                   |
|--------------|----------------------------------------------|---------------------------------|---------------------------|
| Brelan       | Obtenir trois dés de même valeur             | Somme des trois dés identiques  | score de (1,2,2,2,3) : 6  |
| Carré        | Obtenir quatre dés de même valeur            | Somme des quatre dés identiques | score de (1,2,2,2,2) : 8  |
| Full         | Obtenir un brelan et deux dés de même valeur | 25 points                       | score de (1,1,2,2,2) : 25 |
| Petite suite | Obtenir une suite croissante de quatre dés   | 30 points                       | score de (1,2,2,3,4) : 30 |
| Grande suite | Obtenir une suite croissante de cinq dés     | 40 points                       | score de (1,2,3,4,5) : 40 |
| Yahtzee      | Obtenir cinq dés de même valeur              | 50 points                       | score de (2,2,2,2,2) : 50 |

Avant de répondre aux activités suivantes, étudiez la structure et le code présent dans le projet. 
Les méthodes implantées et testées de la classe YahtzeeTour ont été conçue pour vous faciliter la tâche. 
Des exemples de scénarios de tests avec Cucumber sont présents dans le projet.

**Pour chaque cas de figure**

1. Implantez le ou les tests de la méthode du calcul du score d'un tour de partie de Yahtzee.

2. Implantez la méthode du calcul du score d'un tour de partie de Yahtzee pour les cas de figure testés.

3. Effectuez un remaniement du code principal pour en améliorer la qualité et la lisibilité.

## Exigences qualité

- *Une approche BDD avec Cucumber pour rédiger les tests doit être utilisée.*

- Le code produit doit contenir 0 warning/erreur checkstyle, 0 warning/erreur Spotbug.
- Chaque cas de figure est résolu par un membre du binôme dans une branche de feature.
- Chaque cas de figure résolu doit faire l'objet d'une _pull request_ requiérant la revue de code par le membre du binôme
n'ayant pas travaillé sur le cas de figure concerné.
- Les contributions de chaque branche de feature sont intégrées à la branche principale suivant la stratégie "rebase" puis "merge --no-ff"
étudiée dans les précédents TP.



