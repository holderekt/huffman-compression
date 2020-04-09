package application;
import huffmantree.FileLoader;
import huffmantree.HuffmanTree;
import huffmantree.HuffmanTreeInputStream;
import huffmantree.HuffmanTreeOutputStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLoader loader = new FileLoader("mario.txt");
        HuffmanTree tree = new HuffmanTree(loader.readAllBytes());
        tree.print();
        System.out.println("\n --- Write testing --- \n");
        HuffmanTreeOutputStream m = new HuffmanTreeOutputStream(tree, "mario2.txt", null);
        m.write();

        HuffmanTreeInputStream maro = new HuffmanTreeInputStream("mario2.txt");
        maro.loadTree();

    }


}