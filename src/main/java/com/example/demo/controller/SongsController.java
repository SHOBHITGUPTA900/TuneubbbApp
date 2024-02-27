package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongsService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class SongsController {
	@Autowired
	SongsService songrevService;
	@PostMapping("/addsongs" )
	public String addSongs(@ModelAttribute Songs song) {
		boolean status=songrevService.songExixts(song.getName());
		if(status == false) {
			songrevService .addSongs(song);
			return"songsuccess";
		}
		else {
			return "songfail";
		}
		
	}
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model) {
		
		List<Songs> songslist = songrevService.fetchAllSongs();
	model.addAttribute("songslist", songslist);
	//System.out.println(songslistList);
	return "displaysongs";
	}
@GetMapping("/viewsongs")
public String viewCustomerSongs(Model model) {
	List<Songs> songslist = songrevService.fetchAllSongs();
	model.addAttribute("songslist", songslist);
	
boolean primeCustomerStatus= true;
if(primeCustomerStatus == true) {
	return "displaysongs";
}
else {
	return "makepayment";
}
}


}
