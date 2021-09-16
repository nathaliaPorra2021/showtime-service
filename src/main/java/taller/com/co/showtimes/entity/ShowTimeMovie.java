package taller.com.co.showtimes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import taller.com.co.showtimes.model.Movie;

import javax.persistence.*;

@Entity
@Table(name="TBL_SHOWTIME_MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTimeMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id")
    private Long movieId;

    @Transient
    private Movie movie;

}
