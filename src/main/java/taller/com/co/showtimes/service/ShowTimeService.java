package taller.com.co.showtimes.service;

import taller.com.co.showtimes.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {

    public ShowTime createShowTime(ShowTime showTime);

    public List<ShowTime> listAllShowTime();

    public ShowTime getShowTimeById(Long id);

    public ShowTime updateShowTime(ShowTime showTime);
    public void deleteShowTime(Long id);

}
