package org.opendevup.web;
import java.util.List;
import org.opendevup.Dao.IStudentRepositoryDao;
import org.opendevup.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//bijdeze moet je localhost8080/Student/Index Student is de Entity
//Student is contrller en Index is action
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private IStudentRepositoryDao studentRepositoryWeb;
	//url beindeged met/Index roept methde Index returnd view "studenten" 
	@RequestMapping(value="/Index")															
	public String Index(Model model){
		//pour return list des studenten
		List<Student> std=studentRepositoryWeb.findAll();
		//add studenten.html to Model
		model.addAttribute("studenten", std);
		return "studenten";//student ie de naam van view
	}
}
