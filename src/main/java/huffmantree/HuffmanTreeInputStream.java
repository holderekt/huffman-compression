package huffmantree;

import main.java.bitstream.BitInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HuffmanTreeInputStream {
    BitInputStream inStream;

    public HuffmanTreeInputStream(String filename) throws FileNotFoundException {
        inStream = new BitInputStream(filename);
    }

    public void loadTree() throws IOException{
        byte size = inStream.readByte();
        HuffmanNode root = recursiveNodeSearch();
        decodeTree(root);
        inStream.close();
    }

    public HuffmanNode recursiveNodeSearch() throws IOException {
        int currentBit = inStream.read();
        if(currentBit == 1){
            return new HuffmanNode(inStream.readByte(), 0);
        }else{
            HuffmanNode parent = new HuffmanNode(null, 0);
            parent.addLeftNode(recursiveNodeSearch());
            parent.addRightNode(recursiveNodeSearch());
            return parent;
        }
    }

    public byte[] decodeTree(HuffmanNode root) throws IOException {
        System.out.println(inStream.avaible());
        return null;
    }

}
