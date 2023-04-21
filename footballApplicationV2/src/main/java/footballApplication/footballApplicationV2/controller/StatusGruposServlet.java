package footballApplication.footballApplicationV2.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import footballApplication.footballApplicationV2.model.GrpsID;
import footballApplication.footballApplicationV2.model.GruposDadosMod;
import footballApplication.footballApplicationV2.persistence.DaoTime;

@Controller
public class StatusGruposServlet {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "GTdados", value = "/GTdados", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("GTdados");
	}
	
	
	@RequestMapping(name = "GTdados", value="/GTdados", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		//List<GruposDadosMod> la = new ArrayList<>();
		//List<GruposDadosMod> lb = new ArrayList<>();
		//List<GruposDadosMod> lc = new ArrayList<>();
		//List<GruposDadosMod> ld = new ArrayList<>();
		List<GruposDadosMod> lt = new ArrayList<>();
		List<GrpsID> lg = new ArrayList<>();
		try {
			lt = dt.getGrupoDadosMod("T");
			lg = dt.getGrps();
			//la = dt.getGrupoDadosMod("A");
			//lb = dt.getGrupoDadosMod("B");
			//lc = dt.getGrupoDadosMod("C");
			//ld = dt.getGrupoDadosMod("D");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("ListaT", lt);
			model.addAttribute("ListaGRP", lg);
			//model.addAttribute("ListaA", la);
			//model.addAttribute("ListaB", lb);
			//model.addAttribute("ListaC", lc);
			//model.addAttribute("ListaD", ld);
		}
		return new ModelAndView("GTdados");
	}
}
