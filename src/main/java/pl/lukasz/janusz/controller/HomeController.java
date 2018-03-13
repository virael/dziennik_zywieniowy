package pl.lukasz.janusz.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.lukasz.janusz.entity.Meal;
import pl.lukasz.janusz.entity.User;
import pl.lukasz.janusz.repository.MealRepository;
import pl.lukasz.janusz.repository.UserRepository;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MealRepository mealRepository;

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@GetMapping(path = "/user/register")
	public String showAddUserForm(final Model model) {

		final User user = new User();
		model.addAttribute("user", user);
		
		return "user/register";
	}

	@PostMapping(path = "/user/register")
	public String processAddUserForm(final @Valid User user, final BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return "user/register";
		}
		
		userRepository.save(user);
		
		return "redirect:index";
	}
	
	@GetMapping(path = "/meal/add")
	public String showAddMealForm(final Model model) {

		final Meal meal = new Meal();
		model.addAttribute("meal", meal);
		
		return "meal/add";
	}

	@PostMapping(path = "/meal/add")
	public String processAddMealForm(final @Valid Meal meal, final BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return "meal/add";
		}
		
		mealRepository.save(meal);
		
		return "redirect:meal/list";
	}
	
	@GetMapping(path = "/meal/list")
	public String showAllMeals(final Model model) {

		
		final Collection<Meal> meals = mealRepository.findAll();
		
		model.addAttribute("meals", meals);
		return "meal/list";
	}
	
	@GetMapping(path = "/meal/edit")
	public String showEditForm(final @RequestParam(name = "id", required = true) long id, final Model model) {


		final Meal meal = mealRepository.findOne(id);
		
		model.addAttribute("meal", meal);
		return "meal/edit";
	}

	@PostMapping(path = "/meal/edit")
	public String editMeal(final @Valid Meal meal, final BindingResult bresult) {
		
		if(bresult.hasErrors()) {
			return "meal/edit";
		}
		
		
		mealRepository.save(meal);
		
		return "redirect:meal/list";
	}
	
	@GetMapping(path = "/meal/remove")
	public String showDeleteConfirmForm(final @RequestParam(name = "id", required = true) long id, final Model model) {
		
		
		final Meal meal = mealRepository.findOne(id);
		
		model.addAttribute("meal", meal);

		return "meal/remove";
	}
	
	@PostMapping(path = "/meal/remove")
	public String deleteMeal(final @RequestParam(name = "id", required = true) long id) {

		
		mealRepository.delete(id);
		
		return "redirect:list";
	}
}
