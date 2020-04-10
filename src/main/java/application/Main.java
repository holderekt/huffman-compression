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



        String inputFile = "mario2.pdf";
        String outputFile = "mario2.txt";
        String decodedFile = "marioDecoded.pdf";

        FileLoader loader = new FileLoader(inputFile);
        long startTime = System.nanoTime();
        byte[] roba = loader.readAllBytes();
        System.out.println("File loaded             = " + (System.nanoTime() - startTime)/1000000);

        startTime = System.nanoTime();
        HuffmanTree tree = new HuffmanTree(roba);
        System.out.println("HuffmanTree Created     = " + (System.nanoTime() - startTime)/1000000);


        startTime = System.nanoTime();
        HuffmanTreeOutputStream m = new HuffmanTreeOutputStream(tree, outputFile);
        m.write();
        System.out.println("HuffmanTree Wrote       = " + (System.nanoTime() - startTime)/1000000);


        startTime = System.nanoTime();
        HuffmanTreeInputStream maro = new HuffmanTreeInputStream(outputFile);
        HuffmanTree mario = maro.loadTree();
        System.out.println("HuffmanTree Decoded     = " + (System.nanoTime() - startTime)/1000000);

        byte[] aloha = mario.getData();
        startTime = System.nanoTime();
        FileOutputStream a = new FileOutputStream(decodedFile);
        a.write(aloha);
        System.out.println("File wrote              = " + (System.nanoTime() - startTime)/1000000);





    }


}