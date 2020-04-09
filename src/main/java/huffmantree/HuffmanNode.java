package huffmantree;

class HuffmanNode{
    private Byte value;
    private int frequency = 0;
    HuffmanNode leftNode = null;
    HuffmanNode rightNode = null;

    public HuffmanNode(Byte value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }

    public void addLeftNode(HuffmanNode node){
        this.leftNode = node;
    }
    public void addRightNode(HuffmanNode node){
        this.rightNode = node;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public boolean isLeaf(){
        return value != null;
    }

    public byte getValue(){
        return value;
    }
}
