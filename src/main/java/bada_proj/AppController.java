package bada_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
	
	@Autowired
	private RoslinyDAO roslinyDao;
	
	@Autowired
	private SekcjeDAO sekcjeDao;
	
	@Autowired
	private PracownicyDAO pracownicyDao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}
	
	@RequestMapping("/list/rosliny")
	public String listPlants(Model model) {
		List<Roslina> listRosliny = roslinyDao.list();
		model.addAttribute("listRosliny",listRosliny);
		return "list_rosliny";
	}
	
	@RequestMapping("/list/sekcje")
	public String listSections(Model model) {
		List<SekcjaOgrodu> listSekcje = sekcjeDao.list();
		model.addAttribute("listSekcje",listSekcje);
		return "list_sekcje";
	}
	
	@RequestMapping("/list/pracownicy")
	public String listEmployees(Model model) {
		List<Pracownik> listPracownicy = pracownicyDao.list();
		model.addAttribute("listPracownicy", listPracownicy);
		return "list_pracownicy";
	}
	
	@RequestMapping("/new/roslina")
	public String showNewForm(Model model) {
		Roslina roslina = new Roslina();
		model.addAttribute("roslina",roslina);
		
		return "new_roslina";
	}
	
	@RequestMapping("/new/sekcja")
	public String showNewForm2(Model model) {
		SekcjaOgrodu sekcjaOgrodu = new SekcjaOgrodu();
		model.addAttribute("sekcjaOgrodu",sekcjaOgrodu);
		
		return "new_sekcja";
	}
	
	@RequestMapping("/new/pracownik")
	public String showNewForm3(Model model) {
		Pracownik pracownik = new Pracownik();
		model.addAttribute("pracownik", pracownik);
		
		return "new_pracownik";
	}
	
	@RequestMapping(value = "/save/roslina", method = RequestMethod.POST)
	public String save(@ModelAttribute("roslina") Roslina roslina) {
		try {
			roslinyDao.save(roslina);
		}
		catch(java.lang.Exception e) {
			System.err.println(e);
			return "errors/error_new_roslina";
		}
	    return "redirect:/list/rosliny";
	}
	
	@RequestMapping(value = "/save/sekcja", method = RequestMethod.POST)
	public String save2(@ModelAttribute("sekcjaOgrodu") SekcjaOgrodu sekcjaOgrodu) {
	    try{
	    	sekcjeDao.save(sekcjaOgrodu);
		}
		catch(java.lang.Exception e) {
			System.err.println(e);
			return "errors/error_new_sekcja";
		}

	    return "redirect:/list/sekcje";
	}
	
	@RequestMapping(value = "/save/pracownik", method = RequestMethod.POST)
	public String save3(@ModelAttribute("pracownik") Pracownik pracownik) {
	    try{
	    	pracownicyDao.save(pracownik);
		}
	    catch(java.lang.Exception e) {
			System.err.println(e);
			return "errors/error_new_pracownik";
		}
	    return "redirect:/list/pracownicy";
	}
	
	@RequestMapping("/edit/roslina/{nr_rosliny}")
	public ModelAndView showEditForm(@PathVariable(name = "nr_rosliny") int nr_rosliny) {
	    ModelAndView mav = new ModelAndView("edit_roslina");
	    Roslina roslina = roslinyDao.get(nr_rosliny);
	    mav.addObject("roslina", roslina);
	 
	    return mav;
	}
	
	@RequestMapping("/edit/sekcja/{nr_sekcji}")
	public ModelAndView showEditForm2(@PathVariable(name = "nr_sekcji") int nr_sekcji) {
	    ModelAndView mav = new ModelAndView("edit_sekcja");
	    SekcjaOgrodu sekcjaOgrodu = sekcjeDao.get(nr_sekcji);
	    mav.addObject("sekcjaOgrodu", sekcjaOgrodu);
	 
	    return mav;
	}
	
	@RequestMapping("/edit/pracownik/{nr_pracownika}")
	public ModelAndView showEditForm3(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
	    ModelAndView mav = new ModelAndView("edit_pracownik");
	    Pracownik pracownik = pracownicyDao.get(nr_pracownika);
	    mav.addObject("pracownik", pracownik);
	 
	    return mav;
	}
	
	@RequestMapping(value = "/update/roslina", method = RequestMethod.POST)
	public String update(@ModelAttribute("roslina") Roslina roslina) {

		try{
			roslinyDao.update(roslina);
		}
		catch(java.lang.Exception e) {
			System.err.println(e);
			return "errors/error_edit_roslina";
		}
	      
	    return "redirect:/list/rosliny";
	}
	
	@RequestMapping(value = "/update/sekcja", method = RequestMethod.POST)
	public String update2(@ModelAttribute("sekcjaOgrodu") SekcjaOgrodu sekcjaOgrodu) {

		try{
			sekcjeDao.update(sekcjaOgrodu);
		}
		catch(java.lang.Exception e) {
			System.err.println(e);
			return "errors/error_edit_sekcja";
		}
	      
	    return "redirect:/list/sekcje";
	}
	
	@RequestMapping(value = "/update/pracownik", method = RequestMethod.POST)
	public String update3(@ModelAttribute("pracownik") Pracownik pracownik) {

		try{
			pracownicyDao.update(pracownik);
		}
		catch(java.lang.Exception e) {
			System.err.println(e);
			return "errors/error_edit_pracownik";
		}
	      
	    return "redirect:/list/pracownicy";
	}
	
	@RequestMapping("/delete/roslina/{nr_rosliny}")
	public String delete(@PathVariable(name = "nr_rosliny") int nr_rosliny) {
		roslinyDao.delete(nr_rosliny);
		
		return "redirect:/list/rosliny";
	}
	
	@RequestMapping("/delete/sekcja/{nr_sekcji}")
	public String delete2(@PathVariable(name = "nr_sekcji") int nr_sekcji) {
		sekcjeDao.delete(nr_sekcji);
		
		return "redirect:/list/sekcje";
	}
	
	@RequestMapping("/delete/pracownik/{nr_pracownika}")
	public String delete3(@PathVariable(name = "nr_pracownika") int nr_pracownika) {
		pracownicyDao.delete(nr_pracownika);
		
		return "redirect:/list/pracownicy";
	}

	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "errors/access_denied";
	}

	@RequestMapping("/login")
	public String login() {
		return "logging/login";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/login?logout";
	}
}
