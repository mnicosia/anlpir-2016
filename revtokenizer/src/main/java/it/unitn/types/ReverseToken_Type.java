
/* First created by JCasGen Thu Apr 28 17:39:31 CEST 2016 */
package it.unitn.types;

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
 * Updated by JCasGen Thu Apr 28 17:39:31 CEST 2016
 * @generated */
public class ReverseToken_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ReverseToken_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ReverseToken_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ReverseToken(addr, ReverseToken_Type.this);
  			   ReverseToken_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ReverseToken(addr, ReverseToken_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ReverseToken.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("it.unitn.types.ReverseToken");
 
  /** @generated */
  final Feature casFeat_ReversedToken;
  /** @generated */
  final int     casFeatCode_ReversedToken;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getReversedToken(int addr) {
        if (featOkTst && casFeat_ReversedToken == null)
      jcas.throwFeatMissing("ReversedToken", "it.unitn.types.ReverseToken");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ReversedToken);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setReversedToken(int addr, String v) {
        if (featOkTst && casFeat_ReversedToken == null)
      jcas.throwFeatMissing("ReversedToken", "it.unitn.types.ReverseToken");
    ll_cas.ll_setStringValue(addr, casFeatCode_ReversedToken, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public ReverseToken_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ReversedToken = jcas.getRequiredFeatureDE(casType, "ReversedToken", "uima.cas.String", featOkTst);
    casFeatCode_ReversedToken  = (null == casFeat_ReversedToken) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ReversedToken).getCode();

  }
}



    