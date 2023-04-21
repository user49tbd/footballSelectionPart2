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
public class ClassGServlet {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "ClassGeral", value = "/ClassGeral", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		List<GrpsID> lg = new ArrayList<>();
		try {
			lg = dt.getGrps();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("lg", lg);
		}
		return new ModelAndView("ClassGeral");
	}
	@RequestMapping(name = "ClassGeral", value="/ClassGeral", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		String grupo = allParam.get("sl");
		String gp = "";
		List<GrpsID> lg = new ArrayList<>();
		List<GruposDadosMod> lt = new ArrayList<>();
		List<GruposDadosMod> fullList = new ArrayList<>();
		try {
			lt = dt.getGrupoDadosMod(grupo);
			lg = dt.getGrps();
			fullList = dt.getGrupoDadosMod("T");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			gp = lt.get(0).getGrp();
			model.addAttribute("GBusc", lt);
			model.addAttribute("lg", lg);
			model.addAttribute("cgp", gp);
			model.addAttribute("FL", fullList);
		}
		return new ModelAndView("ClassGeral");
	}
}
