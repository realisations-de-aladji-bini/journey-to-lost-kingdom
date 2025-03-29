# Description
Ce projet intitulé **Journey to the Lost Kingdom**, réalisé en Java, est un jeu d'action-aventure avec une vue de dessus, similaire à celui du premier Zelda. Les joueurs contrôlent un personnage principal dans un monde ouvert, explorant des donjons composés de salle, combattant des ennemis et résolvant des énigmes. Des éléments de RPG seront intégrés, permettant aux joueurs d'améliorer les capacités de leur personnage et de collecter des objets. Les joueurs devront collecter des objets clés pour progresser dans le jeu, déverrouillant de nouvelles zones et des capacités spéciales. Le jeu offrira une variété d'armes et d'objets que le joueur peut utiliser pour combattre les ennemis et résoudre des énigmes. L’objectif final est de trouver la couronne sacrée. 

# Structuration du projet

- **src** : code source du jeu
- **doc** : documentation complète du projet (cahier des charges, analyse et conception, manuel utilisateur)
- **res** : contient les différentes images utilisées sur l'interface graphique. Par ailleurs, il est considéré comme notre *Resources Root* 
- **out** : répertoire source des fichiers compilés 

# Compilation et exécution 

### En ligne de commande depuis le répertoire racine du projet
- **Compilation**
```javac -d out $(find src -name "*.java")```
```cp -R res/* out/```

- **Exécution**
```java -cp out main.Main```

### Dans IntelliJ Idea
Marquer le dossier res comme `Ressource Root`  :  
* clique droit sur *`/res` -> Mark Directory as -> Resources Root*  

Lancer le jeu:
* clique droit sur *`/src/main/Main` -> Run main.Main()*