package com.mkrosnicki;

import com.github.javafaker.Faker;
import com.github.javafaker.Superhero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SuperHeroRepository {

  private final Faker faker = new Faker();
  private List<SuperHero> superheroes = new ArrayList<>();

  public SuperHeroRepository() {
    final Superhero superhero = faker.superhero();
    for (int i = 0; i < 100000; i++) {
      final SuperHero superHero = new SuperHero(superhero.name(), superhero.descriptor(), superhero.power());
      superheroes.add(superHero);
    }
  }

  public List<SuperHero> findAllSuperheroes() {
    return new ArrayList<>(superheroes);
  }

  public List<SuperHero> findAllWhereStartsWith(final String prefix) {
    return superheroes.stream()
            .filter(s -> s.getName().toLowerCase().startsWith(prefix))
            .collect(Collectors.toList());
  }

  public List<SuperHero> findAllWhereNameEndsWithAndAgeBelow(final String suffix, final int age) {
    return superheroes.stream()
            .filter(s -> s.getName().endsWith(suffix))
            .filter(s -> s.getAge() < age)
            .collect(Collectors.toList());
  }

  public List<String> findNamesOfYoungerThan(final int age) {
    return superheroes.stream()
            .filter(s -> s.getAge() < age)
            .map(s -> s.getName())
            .collect(Collectors.toList());
  }

  public List<String> findAllNames() {
    return superheroes.stream().map(s -> s.getName()).collect(Collectors.toList());
  }

  public Set<String> findAllNamesUnique() {
    return superheroes.stream().map(s -> s.getName()).collect(Collectors.toSet());
  }

  public int findSumOfAges() {
    return superheroes.stream().mapToInt(s -> s.getAge()).sum();
  }




}
