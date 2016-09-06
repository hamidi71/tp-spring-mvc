package org.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.hadoop.mapred.gethistory_jsp;
import org.opendevup.Dao.IStudentRepositoryDao;
import org.opendevup.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx= SpringApplication.run(TpSpringMvcApplication.class, args);
		IStudentRepositoryDao studentRepository=
				ctx.getBean(IStudentRepositoryDao.class);
		/*DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		studentRepository.save(new Student("Baddi",df.parse("1971-01-07") , "chiahna71@gmail.com", "baddi.jpg"));
		studentRepository.save(new Student("Ilias",df.parse("2002-06-10") , "ilias@gmail.com", "ilias.jpg"));
		studentRepository.save(new Student("Bilal",df.parse("2004-12-15") , "bilal@gmail.com", "bilal.jpg"));
		Page<Student> etds =studentRepository.findAll(new PageRequest(0, 5));
		etds.forEach(e->System.out.println("id is: " + e.getId()+" Name is: "+e.getNom()+" en Date:  "+e.getDateNaissance()+" en mail: " +e.getEmail()));
		
		Page<Student> etds2 =studentRepository.chercherStudent("%i%", new PageRequest(0, 3));
		etds2.forEach(e->System.out.println(e.getNom()));
		System.out.println("Ik ben Klaar");*/
	}
	
}
