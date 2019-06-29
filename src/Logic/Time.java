package Logic;
import Graphics.Song;
import Graphics.SongsManeger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Time extends Thread implements Runnable{

    String time;
    public Time(String time){
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            long diff = calculateTime(time);
            try {
  //              if(diff<=1)
//                    song.setLastTimePlayed("JUST NOW");
               // wait(6000);
                synchronized (time) {
                    time.wait(60000);
                }
                System.out.println(diff);

                System.out.println("sddddddddddddd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long calculateTime(String time){
        if(time.equals("JUST NOW"))
            time = "00:00:00";
        String diff = "00:00:00";
        long difference = 0;
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = null;
        try {
            date1 = format.parse(currentTime);
            Date date2 = format.parse(time);
            difference = date2.getTime() - date1.getTime()/1000;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difference;
    }

    public String getTime() {
        return time;
    }
}




