package pl.lukasz.janusz.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "diary_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@NotNull
	private String firstName;

//	@NotNull
	private String lastName;

//	@NotNull
	private String email;
	
//	@NotNull
	private String password;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy="user", fetch = FetchType.EAGER)
	private List<Meal> meals = new ArrayList<>();
	
//	@OneToMany(cascade = CascadeType.ALL)
//			@JoinColumn(name="id_meal")
//			private List<Meal> meals = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public boolean isPasswordCorrect(String pwd) {
		return BCrypt.checkpw(pwd, this.password);
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", meals=" + meals + "]";
	}
	
	
}
