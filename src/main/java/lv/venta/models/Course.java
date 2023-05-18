package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Setter(value = AccessLevel.NONE) // -> noņem anotāciju (set funkciju) tieši šim mainīgajam
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc; //idc - id course
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-ZĀŠĒĢŪĪĶĻŅŽ]{1}[a-zēīļķšāžņūģ\\ ]+")
	@Size(min = 3, max = 30)
	private String title;
	
	@Column(name = "CreditPoints")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoints;
	
	@OneToOne
	@JoinColumn(name = "Idp") // sasaistām ar otras klases PK
	private Professor professor;
	
	
	@OneToMany(mappedBy = "course")
	private Collection<Grade> grades;
	
	
	
	
	
	// TODO argumenta konstruktors 
	
}
