

/* First created by JCasGen Sun Sep 21 10:52:34 EDT 2014 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Used to annotate name entity 

 * Updated by JCasGen Sun Sep 21 17:40:04 EDT 2014
 * XML source: /Users/apple/git/hw1-yuhsink/hw1-yuhsink-ziy-proto/src/main/resources/typeSystemDescriptor.xml
 * @generated */
public class NameEntity extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NameEntity.class);
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
  protected NameEntity() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NameEntity(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NameEntity(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NameEntity(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
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
  //* Feature: GeneName

  /** getter for GeneName - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeneName() {
    if (NameEntity_Type.featOkTst && ((NameEntity_Type)jcasType).casFeat_GeneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "NameEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NameEntity_Type)jcasType).casFeatCode_GeneName);}
    
  /** setter for GeneName - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneName(String v) {
    if (NameEntity_Type.featOkTst && ((NameEntity_Type)jcasType).casFeat_GeneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "NameEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NameEntity_Type)jcasType).casFeatCode_GeneName, v);}    
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (NameEntity_Type.featOkTst && ((NameEntity_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "NameEntity");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NameEntity_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (NameEntity_Type.featOkTst && ((NameEntity_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "NameEntity");
    jcasType.ll_cas.ll_setStringValue(addr, ((NameEntity_Type)jcasType).casFeatCode_ID, v);}    
  }

    