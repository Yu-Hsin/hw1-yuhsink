/* First created by JCasGen Sun Sep 21 10:52:34 EDT 2014 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/**
 * Used to annotate name entity
 * 
 * Updated by JCasGen Sun Sep 21 17:40:04 EDT 2014
 * 
 * @generated
 */
public class NameEntity_Type extends Annotation_Type {
  /**
   * @generated
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {
    return fsGenerator;
  }

  /** @generated */
  private final FSGenerator fsGenerator = new FSGenerator() {
    public FeatureStructure createFS(int addr, CASImpl cas) {
      if (NameEntity_Type.this.useExistingInstance) {
        // Return eq fs instance if already created
        FeatureStructure fs = NameEntity_Type.this.jcas.getJfsFromCaddr(addr);
        if (null == fs) {
          fs = new NameEntity(addr, NameEntity_Type.this);
          NameEntity_Type.this.jcas.putJfsFromCaddr(addr, fs);
          return fs;
        }
        return fs;
      } else
        return new NameEntity(addr, NameEntity_Type.this);
    }
  };

  /** @generated */
  @SuppressWarnings("hiding")
  public final static int typeIndexID = NameEntity.typeIndexID;

  /**
   * @generated
   * @modifiable
   */
  @SuppressWarnings("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("NameEntity");

  /** @generated */
  final Feature casFeat_GeneName;

  /** @generated */
  final int casFeatCode_GeneName;

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @return the feature value
   */
  public String getGeneName(int addr) {
    if (featOkTst && casFeat_GeneName == null)
      jcas.throwFeatMissing("GeneName", "NameEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GeneName);
  }

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @param v
   *          value to set
   */
  public void setGeneName(int addr, String v) {
    if (featOkTst && casFeat_GeneName == null)
      jcas.throwFeatMissing("GeneName", "NameEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_GeneName, v);
  }

  /** @generated */
  final Feature casFeat_ID;

  /** @generated */
  final int casFeatCode_ID;

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @return the feature value
   */
  public String getID(int addr) {
    if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "NameEntity");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ID);
  }

  /**
   * @generated
   * @param addr
   *          low level Feature Structure reference
   * @param v
   *          value to set
   */
  public void setID(int addr, String v) {
    if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "NameEntity");
    ll_cas.ll_setStringValue(addr, casFeatCode_ID, v);
  }

  /**
   * initialize variables to correspond with Cas Type and Features
   * 
   * @generated
   * @param jcas
   *          JCas
   * @param casType
   *          Type
   */
  public NameEntity_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl) this.casType, getFSGenerator());

    casFeat_GeneName = jcas.getRequiredFeatureDE(casType, "GeneName", "uima.cas.String", featOkTst);
    casFeatCode_GeneName = (null == casFeat_GeneName) ? JCas.INVALID_FEATURE_CODE
            : ((FeatureImpl) casFeat_GeneName).getCode();

    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.String", featOkTst);
    casFeatCode_ID = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl) casFeat_ID)
            .getCode();

  }
}
