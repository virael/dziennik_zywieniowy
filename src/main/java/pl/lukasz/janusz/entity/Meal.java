package pl.lukasz.janusz.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diary_meal")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull
//	@Size(min = 5, max = 50)
	private String name;
	
//	@NotNull
	private int carbs;

//	@NotNull
	private int fat;
	
//	@NotNull
	private int protein;
	
//	@NotNull
	private int kcal;
	
//	@NotNull
	private Date date;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private User user;
//	
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	@JoinColumn(name = "user_id", nullable = true) //tu powinno być false
//	@JoinColumn(name = "id")
//	@ManyToOne
//	private User user;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	public Calendar getDate() {
//		return date;
//	}
//
//	public void setDate(Calendar date) {
//		this.date = date;
//	}

	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", carbs=" + carbs + ", fat=" + fat + ", protein=" + protein
				+ ", kcal=" + kcal + ", date=" + date +  "]"; // ", user=" + user +
	}
	
	
}
