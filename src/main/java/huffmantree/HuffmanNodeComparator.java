package huffmantree;

import java.util.Comparator;

class HuffmanNodeComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode huffmanNode, HuffmanNode t1) {
        if(huffmanNode.getFrequency() > t1.getFrequency())
            return 1;
        else if(huffmanNode.getFrequency() < t1.getFrequency())
            return -1;
        else
            return 0;
    }
}
