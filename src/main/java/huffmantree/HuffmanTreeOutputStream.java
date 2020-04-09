package huffmantree;

import main.java.bitstream.BitOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HuffmanTreeOutputStream {
    HuffmanTree tree;
    BitOutputStream bitOut;
    FileInputStream fileStream;

    public HuffmanTreeOutputStream(HuffmanTree tree, String filename) throws FileNotFoundException {
        this.tree = tree;
        this.bitOut = new BitOutputStream(filename);
    }

    public void write() throws IOException {
        bitOut.write((byte)tree.byteCodes.keySet().size());
        writeTree(tree.root);
        writeData();
        bitOut.close();
        System.out.println("Padding:" + bitOut.getPadding());
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
        for(byte bt : tree.getData()){
            writeBinaryString(tree.getCode(bt));
        }
    }

    private void writeBinaryString(String binstr) throws IOException {
        for(int index = 0; index < binstr.length(); index++){
            bitOut.write(Integer.parseInt(String.valueOf(binstr.charAt(index))));
        }
    }
}
