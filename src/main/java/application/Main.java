package application;
import huffmantree.FileLoader;
import huffmantree.HuffmanTree;
import huffmantree.HuffmanTreeInputStream;
import huffmantree.HuffmanTreeOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) throws IOException {



        String inputFile = "mario.txt";
        String outputFile = "mario2.txt";
        String decodedFile = "marioDecoded.txt";

        FileLoader loader = new FileLoader(inputFile);
        long startTime = System.nanoTime();
        byte[] roba = loader.readAllBytes();
        System.out.println("File loaded             = " + (System.nanoTime() - startTime)/1000000000);
        HuffmanTree tree = new HuffmanTree(roba);
        System.out.println("HuffmanTree Created     = " + (System.nanoTime() - startTime)/1000000000);
        HuffmanTreeOutputStream m = new HuffmanTreeOutputStream(tree, outputFile);
        m.write();
        System.out.println("HuffmanTree Wrote       = " + (System.nanoTime() - startTime)/1000000000);

        HuffmanTreeInputStream maro = new HuffmanTreeInputStream(outputFile);
        HuffmanTree mario = maro.loadTree();
        System.out.println("HuffmanTree Decoded     = " + (System.nanoTime() - startTime)/1000000000);

        byte[] aloha = mario.getData();

        FileOutputStream a = new FileOutputStream(decodedFile);
        a.write(aloha);
        System.out.println("File wrote              = " + (System.nanoTime() - startTime)/1000000000);





    }


}