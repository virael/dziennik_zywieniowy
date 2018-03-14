package pl.lukasz.janusz.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.lukasz.janusz.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long>  {
	
	@Query(value = "select b from Meal b where b.id = ?1")
	Collection<Meal> searchMealByUserId(long id);
	
//	Collection<Meal> findById(long id);

}
//SELECT * FROM `diary_meal` WHERE `user_id` = 1 ORDER BY `date` DESC