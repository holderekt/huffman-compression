package application;
import huffmantree.FrequencyLoader;
import huffmantree.HuffmanTree;
import huffmantree.HuffmanTreeOutputStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FrequencyLoader loader = new FrequencyLoader("mario.txt");
        HuffmanTree tree = new HuffmanTree(loader.read());
        tree.print();
        System.out.println("\n --- Write testing --- \n");
        HuffmanTreeOutputStream m = new HuffmanTreeOutputStream(tree, "mario2.txt", null);
        m.write();

    }


}