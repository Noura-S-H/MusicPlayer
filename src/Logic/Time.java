package Logic;
import Graphics.Song;
import Graphics.SongsManeger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Time extends Thread implements Runnable{

    String time;
    Song song;
    public Time(String time, Song song){
        this.time = time;
        this.song = song;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            if(time == "00:00:00")
                song.setLastTimePlayed("JUST NOW");
           calculateTime(time);
            try {
                wait(60000);
                song.setLastTimePlayed(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String calculateTime(String time){
        String diff = "00:00:00";
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = null;
        try {
            date1 = format.parse(currentTime);
            Date date2 = format.parse(time);
            long difference = date2.getTime() - date1.getTime();
            diff = String.valueOf(difference / 1000);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }



}




