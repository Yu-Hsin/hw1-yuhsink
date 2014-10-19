import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

/**
 * Opens a file, reads sentences line by line, separates the ID and the sentence, and uses
 * "singleSentence" type to store the ID and the sentence itself. For "singleSentence" type, please
 * refer to my report.
 * 
 * @author Yu-Hsin Kuo
 */

public class CollectionReader extends CollectionReader_ImplBase {

  // private ArrayList<BufferedReader> filelist;
  private BufferedReader file;

  // private int fileindex;

  /**
   * This method is called during initialization and it opens the input file.
   */
  @Override
  public void initialize() throws ResourceInitializationException {
    // filelist = new ArrayList<BufferedReader>();
    // fileindex = 0;
    try {
      file = new BufferedReader(new FileReader(
              ((String) getConfigParameterValue("fileName")).toString()));
      // filelist.add(file);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets the next element of the collection.
   * 
   * @param aCAS
   *          the CAS to populate with the next element of the collection
   * @throws IOException
   *           if an I/O failure occurs
   * @throws CollectionException
   *           if there is some other problem with reading from the Collection
   */
  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {

    // BufferedReader file = filelist.get(fileindex++);
    JCas jcas = null;

    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      e.printStackTrace();
    }
    String line;
    
    line = file.readLine();
    String ID, sentence;
    ID = line.substring(0, line.indexOf(" "));
    sentence = line.substring(line.indexOf(" ") + 1);
    singleSentence tmp = new singleSentence(jcas);
    tmp.setID(ID);
    tmp.setSentence(sentence);
    tmp.addToIndexes();
  }

  /**
   * Closes this CollectionReader, after which it may no longer be used.
   * 
   * @throws IOException
   *           if an I/O failure occurs
   */
  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
  }

  /**
   * Gets information about the number of entities and/or amount of data that has been read from
   * this CollectionReader, and the total amount that remains (if that information is available).
   * This method returns an array of Progress objects so that results can be reported using
   * different units. For example, the CollectionReader could report progress in terms of the number
   * of documents that have been read and also in terms of the number of bytes that have been read.
   * In many cases, it will be sufficient to return just one Progress object.
   * 
   * @return an array of Progress objects. Each object may have different units (for example number
   *         of entities or bytes).
   */
  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Gets whether there are any elements remaining to be read from this CollectionReader.
   * 
   * @return true if and only if there are more elements availble from this CollectionReader.
   * @throws IOException
   *           if an I/O failure occurs
   * @throws CollectionException
   *           if there is some other problem with reading from the Collection
   */
  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return file.ready();// fileindex < filelist.size();
  }

}
