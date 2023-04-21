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

import footballApplication.footballApplicationV2.model.TimesMod;
import footballApplication.footballApplicationV2.persistence.DaoTime;

@Controller
public class Times {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "times", value = "/times", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("times");
	}
	
	
	@RequestMapping(name = "times", value="/times", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		
		List<TimesMod> lt = new ArrayList<>();
		
		try {
			lt = dt.getTimes();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("Lista", lt);
		}
		
		return new ModelAndView("times");
		
	}
}
