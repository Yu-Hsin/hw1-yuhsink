import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;


public class RunPosNER {
  
  public static void main (String [] args) throws Exception {
    try {
      BufferedReader file = new BufferedReader(new FileReader(args[0]));
      BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
      PosTagNamedEntityRecognizer a = new PosTagNamedEntityRecognizer();
      String line;
      while((line = file.readLine()) != null) {
        String ID, sentence;
        ID = line.substring(0, line.indexOf(" "));
        sentence = line.substring(line.indexOf(" ") + 1);
        Map <Integer, Integer> span = a.getGeneSpans(sentence);
        for (Integer key:span.keySet()) {
          String geneMention = sentence.substring(key, span.get(key));
          
          String nospacegene = geneMention.replace(" ", "");
          String nospaceline = sentence.replace(" ", "");
          int start = nospaceline.indexOf(nospacegene);
          if (ID.equals("P11882054A0568"))
              System.out.println(span);
          out.write(ID + "|" + start + " " + (start + nospacegene.length()-1)+"|" + geneMention);
          out.write("\n");
        }    
      }
      out.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
            
  
  }
}
