

/* First created by JCasGen Thu Apr 28 17:39:31 CEST 2016 */
package it.unitn.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Apr 28 17:39:31 CEST 2016
 * XML source: /home/noname/workspace/revtokenizer/typesystem/ReverseToken.xml
 * @generated */
public class ReverseToken extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ReverseToken.class);
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
  protected ReverseToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ReverseToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ReverseToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public ReverseToken(JCas jcas, int begin, int end) {
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
  //* Feature: ReversedToken

  /** getter for ReversedToken - gets 
   * @generated
   * @return value of the feature 
   */
  public String getReversedToken() {
    if (ReverseToken_Type.featOkTst && ((ReverseToken_Type)jcasType).casFeat_ReversedToken == null)
      jcasType.jcas.throwFeatMissing("ReversedToken", "it.unitn.types.ReverseToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ReverseToken_Type)jcasType).casFeatCode_ReversedToken);}
    
  /** setter for ReversedToken - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setReversedToken(String v) {
    if (ReverseToken_Type.featOkTst && ((ReverseToken_Type)jcasType).casFeat_ReversedToken == null)
      jcasType.jcas.throwFeatMissing("ReversedToken", "it.unitn.types.ReverseToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((ReverseToken_Type)jcasType).casFeatCode_ReversedToken, v);}    
  }

    