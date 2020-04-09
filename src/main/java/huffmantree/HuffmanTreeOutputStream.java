package huffmantree;

import main.java.bitstream.BitInputStream;
import main.java.bitstream.BitOutputStream;
import main.java.bitstream.BitUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HuffmanTreeOutputStream {
    HuffmanTree tree;
    BitOutputStream bitOut;
    FileInputStream fileStream;
    byte[] data;

    public HuffmanTreeOutputStream(HuffmanTree tree, String filename, byte[] data) throws FileNotFoundException {
        this.tree = tree;
        this.bitOut = new BitOutputStream(filename);
        this.data = data;
    }

    public void write() throws IOException {
        bitOut.write((byte)tree.byteCodes.keySet().size());
        writeTree(tree.root);
        bitOut.close();
    }

    private void writeTree(HuffmanNode node) throws IOException {
        if(node.isLeaf()){
            bitOut.write(1);
            bitOut.write(node.getValue());
        }else{
            bitOut.write(0);
            writeTree(node.leftNode);
            writeTree(node.rightNode);
        }
    }

    private void writeData() throws IOException {
        for(byte bt : data){
            writeBinaryString(tree.getCode(bt));
        }
    }

    //TODO Aggiustare
    private void writeBinaryString(String binstr) throws IOException {
        for(int index = binstr.length() - 1; index >= 0; index--){
            bitOut.write(Integer.parseInt(String.valueOf(binstr.charAt(index))));
        }
    }



}
