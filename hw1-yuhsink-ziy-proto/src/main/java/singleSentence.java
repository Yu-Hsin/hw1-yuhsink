

/* First created by JCasGen Sun Sep 21 14:04:20 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Sun Sep 21 17:40:04 EDT 2014
 * XML source: /Users/apple/git/hw1-yuhsink/hw1-yuhsink-ziy-proto/src/main/resources/typeSystemDescriptor.xml
 * @generated */
public class singleSentence extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(singleSentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected singleSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public singleSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public singleSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (singleSentence_Type.featOkTst && ((singleSentence_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "singleSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((singleSentence_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (singleSentence_Type.featOkTst && ((singleSentence_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "singleSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((singleSentence_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (singleSentence_Type.featOkTst && ((singleSentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "singleSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((singleSentence_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (singleSentence_Type.featOkTst && ((singleSentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "singleSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((singleSentence_Type)jcasType).casFeatCode_sentence, v);}    
  }

    