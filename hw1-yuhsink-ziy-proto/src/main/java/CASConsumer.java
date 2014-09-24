import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

/**
 * Write the final output to a file where each line contains sentence ID, text span and the gene
 * mention.
 * 
 * @author Yu-Hsin Kuo
 */

public class CASConsumer extends CasConsumer_ImplBase {
  private BufferedWriter fop;

  /**
   * This method is called during initialization and it open a file to be written.
   * 
   * @throws ResourceInitializationException
   *           if a failure occurs during initialization
   */
  public void initialize() throws ResourceInitializationException {
    try {
      fop = new BufferedWriter(new FileWriter((String) getConfigParameterValue("outputFile")));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Processes a CAS which has "NameEntity" type and for "NameEntity" type, please refer to my
   * report.
   * 
   * @param aCAS
   *          a CAS to be processed
   * @throws ResourceProcessException
   *           if processing fails for any of the CASes
   */
  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {

    JCas jcas = null;

    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      e.printStackTrace();
    }
    FSIndex index = jcas.getAnnotationIndex(NameEntity.type);
    Iterator iter = index.iterator();
    while (iter.hasNext()) {
      NameEntity tmp = (NameEntity) iter.next();
      try {
        fop.write(tmp.getID() + "|" + tmp.getBegin() + " " + tmp.getEnd() + "|" + tmp.getGeneName());
        fop.write("\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      fop.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
