package com.franka.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.franka.lookify.models.Song;
import com.franka.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository sRep;
	
	public SongService(SongRepository sRep) {
		this.sRep = sRep;
	}
	
	public List<Song> getAllSongs(){
		return sRep.findAll();
	}
	
	public List<Song> getSortedSongs(){
		return sRep.findAllOrderByRatingDesc();
	}
	
	public List<Song> searchByArtist(String search){
		return sRep.findByArtistContaining(search);
	}
	
	public Song findSong(Long id) {
		return sRep.findById(id).get();
	}
	
	public Song createSong(Song s) {
		return sRep.save(s);
	}
	
	public void deleteSong(Long id) {
		sRep.deleteById(id);
	}
}
