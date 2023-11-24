Feature: Calcul du score d'un tour de Yahtzee
  Calcule du score en fonction des cas de figure.

  Rule: Le score correspondant à l'obtention d'un brelan se calcule en sommant la valeur des 3 dés identiques.

    Example: l'obtention des valeurs 1,2,2,3,2 conduit à un score de 6
      Given un utilisateur obtenant [1;2;2;3;2] en jetant ses dés
      Then le score obtenu est 6

    Example: l'obtention des valeurs 6,5,4,6,6 conduit à un score de 18
      Given un utilisateur obtenant [6;5;4;6;6] en jetant ses dés
      Then le score obtenu est 18

  Rule: Le score correspondant à l'obtention d'un Yahtzee est 50.

    Example: l'obtention des valeurs 2,2,2,2,2 conduit à un score de 50
      Given un utilisateur obtenant [2;2;2;2;2] en jetant ses dés
      Then le score obtenu est 50

    Example: l'obtention des valeurs 6,6,6,6,6 conduit à un score de 18
      Given un utilisateur obtenant [6;6;6;6;6] en jetant ses dés
      Then le score obtenu est 50

