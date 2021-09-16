package taller.com.co.showtimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taller.com.co.showtimes.entity.ShowTime;

public interface ShowtimeRepository extends JpaRepository<ShowTime,Long> {
}
