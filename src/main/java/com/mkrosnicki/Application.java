package com.mkrosnicki;

import com.github.javafaker.Superhero;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Application {

  private final SuperHeroRepository superHeroRepository = new SuperHeroRepository();

  public void run() {

    final List<SuperHero> allSuperheroes = superHeroRepository.findAllSuperheroes();
    final List<SuperHero> allWhereStartsWith = superHeroRepository.findAllWhereStartsWith("A");
    final List<SuperHero> heroList = superHeroRepository.findAllWhereNameEndsWithAndAgeBelow("a", 1000);
    final List<String> namesOfYoungerThan = superHeroRepository.findNamesOfYoungerThan(1000);

    final List<String> allNames = superHeroRepository.findAllNames();
    final Set<String> allNamesUnique = superHeroRepository.findAllNamesUnique();
  }

  private void printSuperHeroes(final List<SuperHero> superheroes, final Function<SuperHero, String> printFunction) {
    for (final SuperHero superhero : superheroes) {
      final String functionResult = printFunction.apply(superhero);
      System.out.println("My super hero with " + superhero.getId() + " " + functionResult);
    }
  }

}
