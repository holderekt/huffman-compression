package huffmantree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileLoader {
    private FileInputStream inputStream;
    private LinkedList<Byte> byteData = new LinkedList<>();

    public FileLoader(String filename) throws FileNotFoundException {
        this.inputStream = new FileInputStream(filename);
    }

    public FileLoader(FileInputStream inStream){
        this.inputStream = inStream;
    }

    public byte[] readAllBytes() throws IOException {
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        return data;
    }
}
