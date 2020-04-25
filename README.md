# roll4dice
Simple program that rolls dice and display possible combinations of pairs

Inspired by the board game `Can't stop`:  
This **Kotlin** program draws 4 six-faced dice and proposes all the possible couples of pairs (dice must be associated 2 by 2), ignoring duplicate results.

## Run using Gradle without building

    ./gradlew run


## Build distribution with Gradle

    ./gradlew build

It produces a .zip and a .tar files in build/distributions 


## Run from the distribution

    unzip -d build/ build/distributions/roll4dice-1.0-SNAPSHOT.zip
    build/roll4dice-1.0-SNAPSHOT/bin/roll4dice

Example of output:  
```
4, 4, 2, 3 => [8 AND 5, 6 AND 7]
```