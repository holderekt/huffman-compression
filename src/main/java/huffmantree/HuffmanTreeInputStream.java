package huffmantree;

import main.java.bitstream.BitInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HuffmanTreeInputStream {
    BitInputStream inStream;
    byte size;
    byte padding;

    public HuffmanTreeInputStream(String filename) throws FileNotFoundException {
        inStream = new BitInputStream(filename);
    }

    public HuffmanTree loadTree() throws IOException{
        size = inStream.readByte();
        padding = inStream.readByte();
        HuffmanNode root = recursiveNodeSearch();
        return new HuffmanTree(decodeTree(root), root);
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

        HuffmanNode currentNode = root;
        ArrayList<Byte> dataBuffer = new ArrayList<>();

        while((inStream.avaible() - padding) > 0){
            int bit = inStream.read();
            if(bit == 0)
                    currentNode = currentNode.leftNode;
            else
                    currentNode = currentNode.rightNode;

            if(currentNode.isLeaf()){
                dataBuffer.add(currentNode.getValue());
                currentNode = root;
            }
        }

        byte[] data = new byte[dataBuffer.size()];
        for(int i=0; i<dataBuffer.size(); i++)
            data[i] = dataBuffer.get(i);

        return data;

    }

}
