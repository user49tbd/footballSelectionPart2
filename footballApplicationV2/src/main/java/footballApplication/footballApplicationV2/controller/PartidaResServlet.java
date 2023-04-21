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

import footballApplication.footballApplicationV2.model.PartidaStatusMod;
import footballApplication.footballApplicationV2.persistence.DaoTime;

@Controller
public class PartidaResServlet {
	@Autowired
	DaoTime dt;
	
	@RequestMapping(name = "PartidaRes", value = "/PartidaRes", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		List<String> ls = new ArrayList<>();
		try {
			ls = dt.getTimesNome();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("TimesN", ls);
		}
		return new ModelAndView("PartidaRes");
	}
	
	
	@RequestMapping(name = "PartidaRes", value="/PartidaRes", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		String vals = allParam.get("st1");
		LocalDate data = LocalDate.now();
		PartidaStatusMod psm = new PartidaStatusMod();
		if(!allParam.get("btdt").toString().equals("")){
			data = LocalDate.parse(allParam.get("btdt"));
		}
		
		String upd = allParam.get("upd");
		List<String> ls = new ArrayList<>();
		
		
		try {
			ls = dt.getTimesNome();
			if(!vals.equals("") && data != null) {
				psm = dt.getPartidaStatus(vals, data);
				if(upd != null){
					if(psm.getT1nome() != null && upd.equalsIgnoreCase("Atualizar")) {
					int gol1 = Integer.parseInt(allParam.get("t1nb"));
					int gol2 = Integer.parseInt(allParam.get("t2nb"));
					System.out.println(psm.getT1nome()+psm.getT1grp()+
					" time 1 gols= "+gol1+" - "+
					psm.getT2nome()+" time: "+psm.getT2grp()+
					" time 2 gols= "+gol2);
					PartidaStatusMod sendpsm = psm;
					sendpsm.setT1gols(gol1);
					sendpsm.setT2gols(gol2);
					psm.setT1gols(gol1);
					psm.setT2gols(gol2);
					dt.updPartida(sendpsm, data);
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			model.addAttribute("TimesN", ls);
			model.addAttribute("SeleT", vals);
			model.addAttribute("cdata", data);
			model.addAttribute("psm", psm);
		}
		return new ModelAndView("PartidaRes");
	}
}
