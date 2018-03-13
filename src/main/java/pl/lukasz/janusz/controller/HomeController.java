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

import pl.lukasz.janusz.entity.Meal;
import pl.lukasz.janusz.entity.User;
import pl.lukasz.janusz.repository.MealRepository;
import pl.lukasz.janusz.repository.UserRepository;

@Controller
public class HomeController {
	
//	@Autowired
//	private UserDao bookDao;
	
	
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
			return "user/add";
		}
		
		userRepository.save(user);
		
//		userDao.add(user);
		
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
		
		return "redirect:index";
	}
	
	@GetMapping(path = "/meal/list")
	public String showAllBooks(final Model model) {

		//final Collection<Book> books = bookDao.findAll();
		
		final Collection<Meal> meals = mealRepository.findAll();
		
		model.addAttribute("meals", meals);
		return "meal/list";
	}
	
}
