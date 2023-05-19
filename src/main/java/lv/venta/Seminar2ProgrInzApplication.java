package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class Seminar2ProgrInzApplication {

	public static void main(String[] args) {
		SpringApplication.run(Seminar2ProgrInzApplication.class, args);
	}

	
	@Bean  //izsauks funkciju tajā brīdī kad startēsies sistēma
	public CommandLineRunner testModel(IProfessorRepo profRepo, IStudentRepo studRepo, ICourseRepo courRepo, IGradeRepo grRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Professor pr1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor pr2 = new Professor("Martins", "Saulītis", Degree.mg);
				Professor pr3 = new Professor("Raita", "Rollande", Degree.phd);
				profRepo.save(pr1);
				profRepo.save(pr2);
				profRepo.save(pr3);
				
				
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Kalnina");
				studRepo.save(st1);
				studRepo.save(st2);
				
				// TODO uztaisīt kursu kuram ir piesaistīti 2 profesori
				// TODO uztaisīt gadījumu, kad viens profesors pasniedz divus kursus 
				Course c1 = new Course("Proginz i", 4, new ArrayList<>(Arrays.asList(pr1, pr3))); //vairāku pasniedzēju pievienošana vienam kursam 
				Course c2 = new Course("Datubazes", 4, new ArrayList<>(Arrays.asList(pr2)));
				Course c3 = new Course("Datu struktūras", 2, new ArrayList<>(Arrays.asList(pr1)));
				courRepo.save(c1);
				courRepo.save(c2);
				courRepo.save(c3);
				
				
				c1.addProfessor(pr1);
				c1.addProfessor(pr3);
				c2.addProfessor(pr2);
				c3.addProfessor(pr1);
				courRepo.save(c1);  // saglabā
				courRepo.save(c2);  // datu 
				courRepo.save(c3);  // bāzē
				
				
				grRepo.save(new Grade(10, st1, c1)); //Jānis nopelnija 10 JAVA
				grRepo.save(new Grade(9, st2, c2)); //Baiba nopelnija 9 Datubāzēs
				grRepo.save(new Grade(10, st2, c2)); 
				grRepo.save(new Grade(9, st1, c1));
				
				//TODO izveidot jaunu zaru pāriet uz to (git branch xxx, git checkout xxx)
				//TODO pārveidot saiti starp profesoru un kursu uz ManyToMany
				//TODO pamainīt testModel funkciju, ieliekot 1.profesoram 2 kursus un 1.kursam, ka to pasniedz abi profesori		
			}
		};
	}
	
	
	
	
	
	
	
}
