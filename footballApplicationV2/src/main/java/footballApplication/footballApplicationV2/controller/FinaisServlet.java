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

import footballApplication.footballApplicationV2.model.FinaisMod;
import footballApplication.footballApplicationV2.persistence.DaoTime;
@Controller
public class FinaisServlet {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "finais", value = "/finais", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("finais");
	}
	
	
	@RequestMapping(name = "finais", value="/finais", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		List<FinaisMod> lf = new ArrayList<>();
		try {
			lf = dt.getFinais();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("ListaF", lf);
		}
		return new ModelAndView("finais");
	}
}
