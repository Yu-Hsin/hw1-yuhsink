import java.util.Iterator;
import java.util.Set;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.RegExChunker;




public class RunGeneNER {
  
  public static class EmailRegexChunker extends RegExChunker {

    public EmailRegexChunker() {
        super(EMAIL_REGEX,CHUNK_TYPE,CHUNK_SCORE);
    }

    private final static String EMAIL_REGEX
        = "[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})";

    private final static String CHUNK_TYPE = "email";

    private final static double CHUNK_SCORE = 0.0;

  }
  
  
  public static void main (String [] args) {
  Chunker chunker = new EmailRegexChunker();
  for (int i = 0; i < args.length; ++i) {
      Chunking chunking = chunker.chunk(args[i]);
      System.out.println("input=" + args[0]);
      System.out.println("chunking=" + chunking);
      Set<Chunk> chunkSet = chunking.chunkSet();
      Iterator<Chunk> it = chunkSet.iterator();
      while (it.hasNext()) {
          Chunk chunk = it.next();
          int start = chunk.start();
          int end = chunk.end();
          String text = args[0].substring(start,end);
          System.out.println("     chunk=" + chunk + "  text=" + text);
      }
  }
  }

}
