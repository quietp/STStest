package net.okjsp.gawi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GawiController {
	
	@Autowired
	GameService gameService; 
	
	@RequestMapping(value="/gawi.do", method=RequestMethod.GET)
	public String gawi(Model model) {
		return "gawi";
	}

	@RequestMapping(value="/query.do", method=RequestMethod.POST)
	public String queryJSON(Model model, @ModelAttribute("game") Game game, @RequestParam("callback") String callback) {
		Play play = gameService.play(game);
		Stat stat  = play.getStat();
		
		model.addAttribute("game", game);
		model.addAttribute("stat", stat);
		
		return "queryJSON";
	}

	@RequestMapping(value="/stat.do", method=RequestMethod.GET)
	public String statJSON(Model model) {
		return "statJSON";
	}
}
