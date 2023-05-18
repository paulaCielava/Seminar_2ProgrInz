package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "grade_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {

	@Setter(value = AccessLevel.NONE) // -> noņem anotāciju (set funkciju) tieši šim mainīgajam
	@Column(name = "Idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idg; //idc - id course
	
	@Column(name = "Grade")
	@Min(value = 0)
	@Max(value = 10)
	private int gradeValue;
	
	
	// TODO izveidot argumenta konstruktoru
	
	
	
	
	
	
	
	
}
