package pl.lukasz.janusz.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.lukasz.janusz.bean.LoginData;
import pl.lukasz.janusz.bean.SessionManager;
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

	// @GetMapping(path = "/user/register")
	// public String showAddUserForm(final Model model) {
	//
	//
	// final User user = new User();
	// model.addAttribute("user", user);
	//
	// return "user/register";
	// }
	//
	// @PostMapping(path = "/user/register")
	// public String processAddUserForm(final @Valid User user, final BindingResult
	// bresult) {
	//
	// if(bresult.hasErrors()) {
	// return "user/register";
	// }
	//
	// userRepository.save(user);
	//
	// return "redirect:../meal/list";
	// }

	@GetMapping("/user/register")
	public String showAddUserForm(final Model model) {

		final User user = new User();
		model.addAttribute("user", user);

		return "user/register";
	}

	@PostMapping("/user/register")
	public String processAddUserForm(final @Valid @ModelAttribute User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "redirect:user/register";
		} else {
			this.userRepository.save(user);
			return "redirect:../meal/list";
		}
		
	}

	@GetMapping(path = "/user/login")
	public String login(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "/user/login";
	}

	@PostMapping(path = "/user/login")
	public String loginPost(@ModelAttribute LoginData loginData, Model model, RedirectAttributes redirectAttributes) {
		User user = this.userRepository.findOneByEmail(loginData.getEmail());

		if (user != null && user.isPasswordCorrect(loginData.getPassword())) {
			HttpSession httpSession = SessionManager.session();
			httpSession.setAttribute("user", user);
			redirectAttributes.addFlashAttribute("msg", "Jestes zalogowany!");
			return "redirect:../meal/list";
		}

		model.addAttribute("msg", "Wprowadz poprawne dane");
		return "/user/login";
	}

	@GetMapping("user/logout")
	public String logout(Model model) {
		model.addAttribute("loginData", new LoginData());
		HttpSession httpSession = SessionManager.session();
		httpSession.invalidate();

		return "redirect:../user/login";
	}

	@GetMapping(path = "/meal/add")
	public String showAddMealForm(final Model model) {

		final Meal meal = new Meal();
		model.addAttribute("meal", meal);

		return "meal/add";
	}

	@PostMapping(path = "/meal/add")
	public String processAddMealForm(final @Valid Meal meal, final BindingResult bresult) {

		if (bresult.hasErrors()) {
			return "meal/add";
		}
		
		HttpSession httpSession = SessionManager.session();
		User user = (User) httpSession.getAttribute("user");
		user.getMeals().add(meal);
		this.userRepository.save(user);

//		mealRepository.save(meal);

		return "redirect:list";
	}

	@GetMapping(path = "/meal/list")
	public String showAllMeals(final Model model) {
		HttpSession httpSession = SessionManager.session();
		User user = (User) httpSession.getAttribute("user");

		// final Collection<Meal> meals = mealRepository.findAll();
		// final Collection<Meal> meals = mealRepository.findById(id);
		// final Collection<Meal> meals = mealRepository.searchMealByUserId(id);
		// final Collection<Meal> meals = mealRepository.searchMealByUserId(id);
		// @RequestParam long id,

		model.addAttribute("meals", user.getMeals());
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

		if (bresult.hasErrors()) {
			return "meal/edit";
		}

		mealRepository.save(meal);

		return "redirect:list";
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
