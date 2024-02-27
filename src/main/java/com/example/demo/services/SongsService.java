package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Songs;

public interface SongsService {
public String addSongs(Songs song);

public boolean songExixts(String name);

public void updateSong(Songs song);

List<Songs> fetchAllSongs();



	
}

