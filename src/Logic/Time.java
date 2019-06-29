package Logic;
import Graphics.Song;
import Graphics.SongsManeger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Time extends Thread implements Runnable{

    String time = "00:00:00";
    String now;
    public Time(){
    }

    @Override
    public void run() {
        now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        while (true) {

            try {
                synchronized (now) {
                    now.wait(60000);
                }
                String diff = calculateTime(now);
                time = diff;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String calculateTime(String time){

        String ti = null;
        long difference = 0;
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = null;
        try {
            date1 = format.parse(time);
            Date date2 = format.parse(currentTime);
            difference = date2.getTime() - date1.getTime()/1000;

            long diffSeconds = difference / 1000 % 60;
            long diffMinutes = difference / (60 * 1000) % 60;
            long diffHours = difference / (60 * 60 * 1000) % 24;
            long diffDays = difference / (24 * 60 * 60 * 1000);

             ti = diffDays + ":" + diffHours +":"+ diffMinutes + ":" + diffSeconds ;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ti;
    }

    public String getTime() {
        return time;
    }
}




