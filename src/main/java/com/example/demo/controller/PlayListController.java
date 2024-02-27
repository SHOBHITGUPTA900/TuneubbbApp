package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongsService;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class PlayListController {
	@Autowired
	PlayListService psePlayListService;
	
	@Autowired
	SongsService songsService;
	@GetMapping("/createplaylist")
	
	
	public String createPlayList(Model model) {
		//fetching the song using song service
		
		List<Songs> songslist=songsService.fetchAllSongs();
		//Adding the songs in the model
		
		model.addAttribute("songslist",songslist);
		
		//sending create playlist
		
		return "createplaylist";
		
		
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//TODO: process POST request
		psePlayListService .addPlaylist(playlist);
		
		List<Songs> songsList= playlist.getSongs();
		for(Songs song : songsList) {
			song.getPlaylist().add(playlist);
			songsService.updateSong(song);
			
		}
		return "playlistsuccess";

}
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<PlayList> plistlist =psePlayListService.fetchPlaylists();
		//System.out.println(plistlist);
		model.addAttribute("plistlist",plistlist );
		return "viewPlaylists";
	}
}
