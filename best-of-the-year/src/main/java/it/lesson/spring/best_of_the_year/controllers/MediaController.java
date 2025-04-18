package it.lesson.spring.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.lesson.spring.best_of_the_year.models.Movie;
import it.lesson.spring.best_of_the_year.models.Song;

@Controller
@RequestMapping("/")
public class MediaController {

    /* Step 1 Richiesta NOME
    @GetMapping
    public String bestOfTheYear(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "bestOfTheYear";
    }*/

    @GetMapping
    public String bestOfTheYear(Model model) {
        return "bestOfTheYear";
    }
    
    //Step 2 - FILM
    private List<Movie> getBestMovies(){
        List<Movie> film = new ArrayList<>();
        film.add(new Movie(1, "Il Signore degli Anelli"));
        film.add(new Movie(5, "Lo Hobbit"));
        film.add(new Movie(6, "Spiderman"));
        film.add(new Movie(2, "Il Gladiatore"));
        return film;
    }
    //Lista FILM
    @GetMapping("/movies")
    public String movie(Model model) {
        List<Movie> film = getBestMovies();
        model.addAttribute("film", film);
        /*Stringa FILM
        String movies = "";
        for(Movie m : film){
            movies += m.getTitolo()+", ";
        }
        movies = movies.substring(0, movies.length()-2);
        model.addAttribute("stringFilm", movies);
        */
        return "movie";
    }
    //Ricerca FILM
    @GetMapping("/movies/{id}")
    public String searchMovie(@PathVariable("id") int id, Model model) {
        List<Movie> film = getBestMovies();
        for(Movie f : film){
            if(f.getId() == id){
                model.addAttribute("film", f);
                break;
            }
        }
        return "searchMovie";
    }
 
    //Step 2 - CANZONI
    private List<Song> getBestSongs(){
        List<Song> song = new ArrayList<>();
        song.add(new Song(1, "Paradise City"));
        song.add(new Song(2, "Crazy Train"));
        song.add(new Song(3, "Hotel California"));
        song.add(new Song(5, "Jump"));
        return song;
    }
    //Lista CANZONI
    @GetMapping("/songs")
    public String song(Model model) {
        List<Song> song = getBestSongs();
        model.addAttribute("song", song);
        /*Stringa CANZONI
        String songs = "";
        for(Song s : song){
            songs += s.getTitolo()+", ";
        }
        songs = songs.substring(0, songs.length()-2);
        model.addAttribute("stringSong", songs);
        */
        return "song";
    }
    //Ricerca CANZONI
    @GetMapping("/songs/{id}")
    public String searchSong(@PathVariable("id") int id, Model model) {
        List<Song> song = getBestSongs();
        Song selectedSong = null;
        for(Song s : song){
            if(s.getId() == id){
                //model.addAttribute("song", s);
                selectedSong = s;
                break;
            }
        }
        if(selectedSong != null){
            model.addAttribute("song", selectedSong);
            return "song" + id;
        }
        else{
            return "searchSong";
        }
    }
}