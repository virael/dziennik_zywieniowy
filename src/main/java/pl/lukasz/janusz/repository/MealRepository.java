package pl.lukasz.janusz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukasz.janusz.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long>  {

}
