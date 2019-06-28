package Graphics.south.center;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;

import java.io.FileInputStream;

public class Duration {
    private double durationInSecond;
    private FileInputStream fileInput;

    public Duration(String name){
        Header header = null;
        try{
            fileInput = new FileInputStream(name);
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        Bitstream bitstream = new Bitstream(fileInput);

        try{
            header = bitstream.readFrame();
        }catch(BitstreamException e){
            e.printStackTrace();
        }

        int size = header.calculate_framesize();
        float secondPerFrame = header.ms_per_frame();
        int max = header.max_number_of_frames(10000);
        float total = header.total_ms(size);
        long totall =0;

        try{
            totall = fileInput.getChannel().size();

        }catch(Exception ex){
            ex.printStackTrace();
        }

        int min = header.min_number_of_frames(500);
        durationInSecond = header.total_ms((int)totall/1010);
    }

    public double getDurationInSecond(){
        return this.durationInSecond;
    }

}
