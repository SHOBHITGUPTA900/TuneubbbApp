package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repositories.SongsRepository;
@Service
public class SongsServiceImplementation implements SongsService{
@Autowired
	SongsRepository  sRepository;
	@Override
	public String addSongs(Songs song) {
		sRepository.save(song);
		
		
		return "return song is added";
	}
	@Override
	public boolean songExixts(String name) {
		Songs song= sRepository.findByName(name);
		if(song==null) {
			return false;
		}
		else{
			return true;
		}
		
	}
	@Override
	public List<Songs> fetchAllSongs() {
		
	List<Songs> songslist =sRepository.findAll();
	
		return songslist;
	}
	@Override
	public void updateSong(Songs song) {
		sRepository.save(song);
		
	}

}
