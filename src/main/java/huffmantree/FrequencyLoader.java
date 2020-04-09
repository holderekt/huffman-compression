package huffmantree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencyLoader{
    private FileInputStream inputStream;
    private LinkedList<Byte> byteData = new LinkedList<>();

    public FrequencyLoader(String filename) throws FileNotFoundException {
        this.inputStream = new FileInputStream(filename);
    }

    public FrequencyLoader(FileInputStream inStream){
        this.inputStream = inStream;
    }

    public Map<Byte, Integer> read() throws IOException {
       Map<Byte, Integer> data = new HashMap<>();
       readAllBytes();

       while(inputStream.available() > 0){
           byteData.add((byte)inputStream.read());
       }

       for(byte bt : byteData){
           if(data.containsKey(bt)){
                data.put(bt, data.get(bt) + 1);
           }else{
               data.put(bt, 1);
           }
       }
       return data;
    }

    public List<Byte> readAllBytes() throws IOException {
        if(byteData.size() != 0){
            while(inputStream.available() > 0){
                byteData.add((byte)inputStream.read());
            }
        }
        return byteData;
    }
}
