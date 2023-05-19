package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Person{
	
	// TODO uzlikt dataJPA anotācijas 
	// TODO uzlikt atbilstošas validāciju anotācijas
	// TODO izveidot Student klasi
	// TODO izveidot Course klasi
	// TODO izveidot Grade klasi
	 
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	@ToString.Exclude
	@ManyToMany(mappedBy = "professors")
	private Collection<Course> courses = new ArrayList<>();
	

	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		this.degree = degree;
	}
	
	// šis ir tikai ManyToMany gadījumā
	public void addCourse (Course inputCourse) {
		if (!courses.contains(inputCourse)) {
			courses.add(inputCourse);
		}
	}
	
	//izveidot profecora dzēšanas funkciju
	
	
}
