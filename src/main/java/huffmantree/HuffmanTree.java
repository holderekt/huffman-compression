package huffmantree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    HuffmanNode root;
    HashMap<Byte, String> byteCodes = new HashMap<>();

    public HuffmanTree(Map<Byte, Integer> byteFrequencies){
        PriorityQueue<HuffmanNode> queue = new PriorityQueue(new HuffmanNodeComparator());

        for(Byte bt : byteFrequencies.keySet()){
            queue.add(new HuffmanNode(bt, byteFrequencies.get(bt)));
        }

        do{
            HuffmanNode leftNode = queue.poll();
            HuffmanNode rightNode = queue.poll();
            HuffmanNode parent = new HuffmanNode(
                    null,
                    leftNode.getFrequency() + rightNode.getFrequency());

            parent.addLeftNode(leftNode);
            parent.addRightNode(rightNode);
            queue.add(parent);
        }while(queue.size() != 1);

        this.root = queue.poll();
        this.generateCodes();
    }

    public HuffmanTree(HuffmanNode root){
        this.root = root;
        generateCodes();
    }

    private void generateCodes(){
        this.generateCodeRecursive(root, "");
    }

    private void generateCodeRecursive(HuffmanNode node, String bufferString){
        if(isLeaf(node)){
            System.out.println("");
            byteCodes.put(node.getValue(), bufferString);
        }else{
            generateCodeRecursive(node.leftNode, bufferString + "0");
            generateCodeRecursive(node.rightNode, bufferString + "1");
        }
    }

    private boolean isLeaf(HuffmanNode node){
        return node.isLeaf();
    }

    public void print(){
        for(Byte b : byteCodes.keySet()){
            System.out.println((char) b.byteValue() + " " + byteCodes.get(b));
        }
    }
}
