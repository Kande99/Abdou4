package com.saraya.SpringBoot2;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("UserName")
public class TireController {

	@Autowired
	TireService ts;
	@RequestMapping(value="/list-tire", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("tires", ts.getAllTires());
		return "tireList";
	}
	
	//------------------ADDING METHOD----------------------------
	
	@RequestMapping(value="/add-tire", method=RequestMethod.GET)
			public String addScooterForm(ModelMap model) {
		model.addAttribute("highbrow", new Tire());
		return "addTire";
	}
	
	@RequestMapping(value="/add-tire", method=RequestMethod.POST)
	public String tireAdded(ModelMap model, @Valid @ModelAttribute("highbrow") Tire t, BindingResult result) {
		if(result.hasErrors()) {
			return "addTire";
		}
		ts.addTire(t.getYear(), t.getMake(), t.getModel(), t.getImage());
		model.clear();
		return "redirect:/list-tire";
	}
	
	
	//----------------------------------------------------------------
	
	
	
	//--------------UPDATE METHOD-----------------------------
	
	@RequestMapping(value="/update-tire", method=RequestMethod.GET)
	public String updateTireForm(ModelMap model, @RequestParam int id) {
		model.addAttribute("highbrow", ts.findById(id));
		return "addTire";
	}
	//-------------------------------------------------
	@RequestMapping(value="/update-tire", method=RequestMethod.POST)
	public String tireListUpdate(ModelMap model, @Valid @ModelAttribute("road") Tire t,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTire";
		}
		
		ts.updateByTire(t);
		model.clear();
		return "redirect:/list-tire";
	}
	//-----------------------------------------------------
	
	@RequestMapping(value="/delete-tire", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		ts.deleteTire(id);
		model.clear();
		return "redirect:/list-tire";
		
	}
}