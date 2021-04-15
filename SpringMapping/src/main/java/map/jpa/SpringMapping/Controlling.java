package map.jpa.SpringMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlling 
{
	Person person;
	List<Laptop> pcs;
	@Autowired
	Repos repo;
	@Autowired
	ReposLap repos;
	@RequestMapping("/newper")
	public String check(Model model)
	{
		Person per=new Person();
		model.addAttribute("obj", per);
		return "newperson";
	}
	@RequestMapping(value="/addper",method=RequestMethod.POST)
	public String addingper(Model model, @ModelAttribute("person") Person person)
	{
		repo.save(person);
		model.addAttribute("info", person.getName()+"added");
		return "newperson";
	}
	
	@RequestMapping("/")
	public String begin()
	{
		return "index";
	}
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public String logging(Model model, @RequestParam("user") String User)
	{
		System.out.println("Entered user is: "+User);
		person=repo.findByName(User);
		System.out.println("Found: "+person.getId());
		model.addAttribute("user", person.getName());
		model.addAttribute("object", person);
		pcs=repos.findAllByPersonId(person.getId());
		model.addAttribute("all", pcs);
		return "home";
	}
	
	@RequestMapping("/newlap")
	public String laptop(Model model)
	{
		Laptop lap=new Laptop();
		model.addAttribute("object", lap);
		return "newlaptop";
	}
	
	@RequestMapping(value="/addlap",method=RequestMethod.POST)
	public String addingper(Model model, @ModelAttribute("laptop") Laptop laptop)
	{
		System.out.println("PErson in add lap "+person.getName());
		laptop.setPerson(person);
		repos.save(laptop);
		//repo.save(person);
		model.addAttribute("info", laptop.getModel()+"added");
		pcs=repos.findAllByPersonId(person.getId());
		model.addAttribute("all", pcs);
		return "home";
	}
}
