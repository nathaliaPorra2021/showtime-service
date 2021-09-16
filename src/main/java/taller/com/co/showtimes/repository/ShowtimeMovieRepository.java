package taller.com.co.showtimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taller.com.co.showtimes.entity.ShowTime;
import taller.com.co.showtimes.entity.ShowTimeMovie;

public interface ShowtimeMovieRepository extends JpaRepository<ShowTimeMovie,Long> {
}
