package huffmantree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    HuffmanNode root;
    HashMap<Byte, String> byteCodes = new HashMap<>();
    byte[] data;


    public HuffmanTree(byte[] data, HuffmanNode root){
        this.data = data;
        this.root = root;
        this.generateCodes();
    }


    public HuffmanTree(byte[] data){
        this.data = data;
        this.root = generateTree(generateQueue(calculateFrequency(data)));
        this.generateCodes();
    }


    private HuffmanNode generateTree(PriorityQueue<HuffmanNode> queue){
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

        return queue.poll();
    }


    private PriorityQueue<HuffmanNode> generateQueue(Map<Byte, Integer> frequency){
        PriorityQueue<HuffmanNode> queue = new PriorityQueue(new HuffmanNodeComparator());
        for(Byte bt : frequency.keySet()){
            queue.add(new HuffmanNode(bt, frequency.get(bt)));
        }
        return queue;
    }


    private Map<Byte, Integer> calculateFrequency(byte[] data){
        Map<Byte, Integer> dataFrequency = new HashMap<>();
        for(byte bt : data){
            if(dataFrequency.containsKey(bt)){
                dataFrequency.put(bt, dataFrequency.get(bt) + 1);
            }else{
                dataFrequency.put(bt, 1);
            }
        }
        return dataFrequency;
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

    public String getCode(byte b){
        return byteCodes.get(b);
    }
}
