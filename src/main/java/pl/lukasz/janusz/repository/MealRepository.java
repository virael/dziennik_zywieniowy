package pl.lukasz.janusz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.lukasz.janusz.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long>  {
	
//	@Query(value = "select b from Meal b where b.id = ?1")
//	@Query(value = "select u, m from User u, Meal m where m.user_id = u.id")
//	Collection<Meal> searchMealByUserId(long id);
	
	
	
//	SELECT b, p FROM Book b, Publisher p WHERE b.fk_publisher = p.id
//	Collection<Meal> findById(long id);

}
//SELECT * FROM `diary_meal` WHERE `user_id` = 1 ORDER BY `date` DESC

//SELECT diary_meal.id, diary_meal.carbs, diary_meal.name, diary_meal.fat, diary_meal.date, diary_meal.kcal, diary_meal.protein
//FROM diary_meal
//JOIN diary_user
//ON diary_meal.user_id = diary_user.id
//WHERE diary_user.id = 2