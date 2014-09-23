import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.*;
import com.aliasi.util.AbstractExternalizable;

/**
 * Run the name-entity recognizer of Lingpipe, which uses a pre-trained character language model
 * HMM. It performs first-best name-entity chunking that returns the begin and end indexes.
 * Calculate the whitespace-excluded offsets here.
 * 
 * @author Yu-Hsin Kuo
 */

public class NameEntityAnnotator extends JCasAnnotator_ImplBase {

  /**
   * This method is overriden and it does name-entity recognition.
   * 
   * @param aJCas
   *          the JCas containing the inputs to the processing. Analysis results will also be
   *          written to this JCas. The JCas should contain "singleSentence" type. For
   *          "sigleSentence type", please refer to my report.
   * 
   * @throws AnalysisEngineProcessException
   *           if a failure occurs during processing
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

    File modelFile = new File((this.getClass().getClassLoader()
            .getResource((String) getContext().getConfigParameterValue("model")).getPath()));

    Chunker chunker = null;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (ClassNotFoundException e1) {
      e1.printStackTrace();
    }

    FSIterator iter = aJCas.getJFSIndexRepository().getAllIndexedFS(singleSentence.type);

    while (iter.hasNext()) {
      singleSentence tmp = (singleSentence) iter.next();
      String line = tmp.getSentence();

      Chunking chunking = chunker.chunk(line);
      Set<Chunk> chunkSet = chunking.chunkSet();
      Iterator<Chunk> it = chunkSet.iterator();
      while (it.hasNext()) {
        Chunk chunk = it.next();
        int start = chunk.start();
        int end = chunk.end();
        String gene = line.substring(start, end);
        NameEntity tmpNE = new NameEntity(aJCas);
        // calculate whitespace-excluded offsets
        String nospacegene = gene.replace(" ", "");
        String nospaceline = line.replace(" ", "");
        start = nospaceline.indexOf(nospacegene);
        tmpNE.setBegin(start);
        tmpNE.setEnd(start + nospacegene.length() - 1);
        tmpNE.setID(tmp.getID());
        tmpNE.setGeneName(gene);
        tmpNE.addToIndexes();
      }

    }
  }

}
