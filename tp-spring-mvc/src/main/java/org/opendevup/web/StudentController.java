//video1 26 min
package org.opendevup.web;
import java.util.List;

import org.opendevup.Dao.IStudentRepositoryDao;
import org.opendevup.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//bijdeze moet je localhost8080/Student/Index Student is de Entity
//Student is contrller en Index is action
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private IStudentRepositoryDao studentRepositoryWeb;
	//url beindeged met uri:/Index roept methde Index returnd view "studenten.html" 
	@RequestMapping(value="/Index")	
	//defaultvalue="0"----> page
	//http://localhost:8080/student/Index?page=1 met @RequestParam
	//http://localhost:8080/student/Index?p=1 zonder @RequestParam
	public String Index(Model model,@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="key",defaultValue="0") String ky){
		//Page<Student> pageStudentent=studentRepositoryWeb.findAll(new PageRequest(p, 11));
		Page<Student> pageStudentent=studentRepositoryWeb.chercherStudent("%"+ky+"%",new PageRequest(p,5));
		int pagesCount=pageStudentent.getTotalPages();
		int[] pages=new int[pagesCount];
		for(int i=0;i<pagesCount;i++)pages[i]=i;
		model.addAttribute("pagesView", pages);
		model.addAttribute("pagestudenten", pageStudentent);
		model.addAttribute("pageCourante", p);
		model.addAttribute("key", ky);
		//pour return list des studenten
		/*List<Student> std=studentRepositoryWeb.findAll();
		add studenten.html to Model
		model.addAttribute("studenten", std);*/
		return "studenten";//student ie de naam van view
	}
}
