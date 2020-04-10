package huffmantree;

import bitstream.BitOutputStream;
import bitstream.BufferedBitOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HuffmanTreeOutputStream {
    HuffmanTree tree;
    BitOutputStream bitOut;
    FileInputStream fileStream;

    public HuffmanTreeOutputStream(HuffmanTree tree, String filename) throws FileNotFoundException {
        this.tree = tree;
        this.bitOut = new BufferedBitOutputStream(filename);
    }

    public void write() throws IOException {
        bitOut.write((byte)tree.byteCodes.keySet().size());
        bitOut.write((byte)paddingPreview());
        writeTree(tree.root);
        writeData();
        bitOut.close();
    }

    private int paddingPreview(){
        int padding = tree.size;
        for(byte b : tree.getData()){
            padding += tree.getCode(b).length();
        }
        return 8 - padding % 8;
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
