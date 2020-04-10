# Huffman Coding
Code and decode streams for Huffman trees.

### Compression Rate
The compression alghorithm has been tested on the "Large Corpus" from http://corpus.canterbury.ac.nz

|             | Description                              | Initial Size | Compressed Size  | Compression Rate |
|-------------|------------------------------------------|--------------|------------------|------------------|
| word192.txt | The CIA world fact book                  | 2.4MB        | 1.5MB            | 62.5%            |
| bible.txt   | The King James version of the bible      | 3.9MB        | 2.1MB            | 53.8%            |
| E.coli      | Complete genome of the E. Coli bacterium | 4.4MB        | 1.1MB            | 25%              |

### Dependency
- BitStreamInput and BitStreamOutput (My own library) https://github.com/holderekt/bitstream-java

