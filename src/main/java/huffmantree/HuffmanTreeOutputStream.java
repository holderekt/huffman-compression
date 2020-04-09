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
        this.bitOut = new BitOutputStream("mario2.txt");
        this.data = data;
    }

    public void write() throws IOException {
        bitOut.write((byte)tree.byteCodes.keySet().size());
        writeTree(tree.root);
        bitOut.close();
        testread();
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


    public void testread() throws IOException{
        BitInputStream test = new BitInputStream("mario2.txt");
        byte a = test.readByte();
        HuffmanNode root = recursiveNodeSearch(test);
        HuffmanTree mario = new HuffmanTree(root);
        mario.print();

        test.close();
    }

    public HuffmanNode recursiveNodeSearch(BitInputStream stream) throws IOException {
            int currentBit = stream.read();
            if(currentBit == 1){
                return new HuffmanNode(stream.readByte(), 0);
            }else{
                HuffmanNode parent = new HuffmanNode(null, 0);
                parent.addLeftNode(recursiveNodeSearch(stream));
                parent.addRightNode(recursiveNodeSearch(stream));
                return parent;
            }
    }
}
