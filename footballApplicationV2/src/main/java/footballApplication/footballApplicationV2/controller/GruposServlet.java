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

import footballApplication.footballApplicationV2.model.GruposMod;
import footballApplication.footballApplicationV2.persistence.DaoTime;

@Controller
public class GruposServlet {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "grupos", value = "/grupos", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("grupos");
	}
	
	
	@RequestMapping(name = "grupos", value="/grupos", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		List<GruposMod> la = new ArrayList<>();
		List<GruposMod> lb = new ArrayList<>();
		List<GruposMod> lc = new ArrayList<>();
		List<GruposMod> ld = new ArrayList<>();
		
		try {
			la = dt.getGrupos("A");
			lb = dt.getGrupos("B");
			lc = dt.getGrupos("C");
			ld = dt.getGrupos("D");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("ListaA", la);
			model.addAttribute("ListaB", lb);
			model.addAttribute("ListaC", lc);
			model.addAttribute("ListaD", ld);
		}
		
		return new ModelAndView("grupos");
		
	}
}
