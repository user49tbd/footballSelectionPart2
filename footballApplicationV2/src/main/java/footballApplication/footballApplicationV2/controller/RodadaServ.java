package footballApplication.footballApplicationV2.controller;

import java.sql.SQLException;
import java.time.LocalDate;
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

import footballApplication.footballApplicationV2.model.RodadaMod;
import footballApplication.footballApplicationV2.persistence.DaoTime;

@Controller
public class RodadaServ {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "rodadas", value = "/rodadas", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("rodadas");
	}
	
	
	@RequestMapping(name = "rodadas", value="/rodadas", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		LocalDate ld=LocalDate.now();
		String data = allParam.get("datatxt");
		if(data != "") {
			ld = LocalDate.parse(data);
		}
		String msg = "";
		List<RodadaMod> listr = new ArrayList<>();
		
		try {
			listr = dt.getRodada(ld);
			msg = dt.getMsg();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("msg", msg);
			model.addAttribute("list", listr);
		}
		
		return new ModelAndView("rodadas");
		
	}
}
