package com.tv.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.tv.mvc.services.TvServices;
import com.tv.mvc.validator.UserVal;

import com.tv.mvc.models.*;
@Controller

public class Shows {
	
	private final UserVal userVal;
	private final TvServices tvServices;
	
	public Shows( UserVal userVal, TvServices tvServices) {
		
		this.tvServices = tvServices;
		this.userVal = userVal;
	}

	
	
	   

	@RequestMapping("/")
	public 	String logister(@ModelAttribute("user") User user) {
		
		return "loginRegister.jsp";	
		
	}




	@PostMapping(value="/reg")
	public String regi(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 userVal.validate(user, result);

		 if(result.hasErrors()) {
		return "loginRegister.jsp";
	}
	System.out.println(user.getPassword());

	User objetoUser = tvServices.regis(user);
	session.setAttribute("id_user", objetoUser.getId());

	return "redirect:/shows";
	}
			















	@PostMapping(value="/login")
	public String loger(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
	boolean isAuthenticated = tvServices.authentic(email, password);
	
	if(isAuthenticated) {
		
		User userMail = tvServices.findByEmail(email);
		
		session.setAttribute("id_user", userMail.getId());
		
		
		return "redirect:/shows";
	
	}else {
		model.addAttribute("error", "BAD!!!! TRY AGAIN");
		return "loginRegister.jsp";
	}



	}
















@GetMapping("/shows")
public 	String show( HttpSession session,Model model ) {
	
	Long id_user = (Long) session.getAttribute("id_user");
			
	 
	
	List<Show> shows = tvServices.mostrarTodosLosShow();
		
     User user = tvServices.buscarUser(id_user);
	model.addAttribute("user", user);
	model.addAttribute("shows", shows);
	System.out.println("id_user" + id_user);
	return "shows.jsp";
}





@GetMapping("/shows/new")
public 	String showNew( HttpSession session) {
	return "showRegister.jsp";
}

@PostMapping("/shows")

public 	String savShow( @RequestParam("name_show") String nameShow,@RequestParam("name_network") String nameNetwork, HttpSession session,Model model) {
User user = tvServices.buscarUser((Long)session.getAttribute("id_user"));

	Show showBuscado = tvServices.findByShow(nameShow);
	
	if(showBuscado != null) {
		model.addAttribute("mensajeShow", "Show EXIST!!");
		return "showRegister.jsp";
		
	}else {
		
	Network netBuscado = tvServices.findByNet(nameNetwork);
	
	
	if(netBuscado != null) {
	
		System.out.println("no null");
		
		Show show = new Show();
		
		show.setName(nameShow);
		show.setNetwork(netBuscado);
		show.setUser(user);
	       tvServices.crearShow(show);

		return "redirect:/shows";
		
	}else { 
		System.out.println("null");

		Network netNew = new Network();
		netNew.setName(nameNetwork);		
  tvServices.crearNetwork(netNew);

		
	Show showNew = new Show();
		showNew.setName(nameShow);
		showNew.setUser(user);
		showNew.setNetwork(netNew);
		 tvServices.crearShow(showNew);
		
		
		
		
			return "redirect:/shows";
		
	}
	

		
	}
	
	
	
	
}






@GetMapping("/shows/{id}")
public 	String show(@PathVariable("id") Long id_idea, Model model) {
	Show show = tvServices.buscarShow(id_idea);
	model.addAttribute("showID", show.getId());
	model.addAttribute("show",show);
	return "showShow.jsp";
}








@GetMapping(value="/shows/{id}/edi")
public String editIdea(@PathVariable("id") Long id_show, HttpSession session, Model model) {
	System.out.println("entre");
Show show = tvServices.buscarShow(id_show);
	
Long userID = (Long) session.getAttribute("id_user");
	
	if(userID!=show.getUser().getId()) {
		
		return "redirect:/shows";
			}
	
	model.addAttribute("show", show);

		return "showEdit.jsp";
}



@PostMapping(value="/shows/rat")

public String rat(HttpSession session, @RequestParam("id_show") Long id_show, @RequestParam("rat") String rat) {
User user = tvServices.buscarUser((Long)session.getAttribute("id_user"));
Show showbus = tvServices.buscarShow(id_show);



Double pts = Double.parseDouble(rat);
Show show = tvServices.buscarShow(id_show);
double suma=0;


Rating ratx = new Rating();
ratx.setUser(user);
ratx.setRating_pts(pts);
ratx.setShow(show);


tvServices.crearRating(ratx);


Show showCont = tvServices.buscarShow(id_show);

for (int i = 0; i < showCont.getRatings().size(); i++) {
	suma = suma + show.getRatings().get(i).getRating_pts();
}

double avg = suma /showCont.getRatings().size();
showCont.setAvg_rating(avg);
tvServices.crearShow(showCont);
return "redirect:/shows";
}




@PostMapping("/shows/edit")

public 	String edShow(@RequestParam("show_id") Long id_show, @RequestParam("name_show") String nameShow,@RequestParam("name_network") String nameNetwork, HttpSession session,Model model) {
User user = tvServices.buscarUser((Long)session.getAttribute("id_user"));

	Show showBuscado = tvServices.findByShow(nameShow);
	
	if(showBuscado != null) {
		model.addAttribute("show", showBuscado);
		model.addAttribute("mensajeShow", "Show EXIST!!");
		return "showEdit.jsp";
		
	}else {
		
	Network netBuscado = tvServices.findByNet(nameNetwork);
	
	
	if(netBuscado != null) {
	
		System.out.println("no null");
		
		Show show = new Show();
		
		show.setName(nameShow);
		show.setNetwork(netBuscado);
		show.setUser(user);
		show.setId(id_show);
	       tvServices.crearShow(show);

		return "redirect:/shows";
		
	}else { 
		System.out.println("null");

		Network netNew = new Network();
		netNew.setName(nameNetwork);		
  tvServices.crearNetwork(netNew);

		
	Show showNew = new Show();
		showNew.setName(nameShow);
		showNew.setUser(user);
		showNew.setNetwork(netNew);
		showNew.setId(id_show);
		
		tvServices.crearShow(showNew);
		
		
		
		
			return "redirect:/shows";
		
	}
	

		
	} }





@GetMapping("/shows/{id}/delete")
public String sjpwDelete( @PathVariable("id") Long id_show) {
Show show = tvServices.buscarShow(id_show);
	tvServices.borrarShow(show);
	return "redirect:/shows";
}
}