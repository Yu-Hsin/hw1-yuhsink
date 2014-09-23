/**
 * Provides universal utility methods that can be used across different classes
 * 
 * @author apple
 * 
 */

public class Utility {

  /**
   * Calculate the start index of the gene in the sentence without considering the whitespace
   * 
   * @param gene
   *          the gene mention
   * @param sentence
   *          the original sentence
   * @return the start index of the gene without calculating the whitespace
   */
  static int calOffset(String gene, String sentence) {
    String nospacegene = gene.replace(" ", "");
    String nospacesent = sentence.replace(" ", "");
    return nospacesent.indexOf(nospacegene);
  }
}
