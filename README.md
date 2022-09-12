# test-orangebank
Test pour le recrutement chez Orange BANK.

## Les étapes:
1. Récupérer les repos JetBrain via l'API github.
2.  Les montrer dans une liste avec les champs suivants : full_name, description, forks, open_issues, watchers
3. Pull to refresh et cas d'erreur
4. Test du code (pas de notion de déploiement continu, etc, car cela serait trop long à implémenter).

## À propos de la réalisation du test
- Architecture choisie: La Clean Architecture. Inspirée de [mon projet portfolio en Flutter pour le Web](https://bitbucket.org/Mackovich/flutter-portfolio-vincent-ricard/src/master/).
- Code 100% en Kotlin, avec du Flow et des Coroutines
- Utilisation au maximum des APIs stables des Android Architecture Components
- Injection des dépendances avec Hilt
- Material Design (via Material Components)
- Couche Réseau: okhttp + Retrofit2 + Gson
- Le repo est configuré en GitFlow.
