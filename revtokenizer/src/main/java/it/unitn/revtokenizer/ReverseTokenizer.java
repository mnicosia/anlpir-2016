package it.unitn.revtokenizer;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.descriptor.TypeCapability;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import it.unitn.types.ReverseToken;

/**
 * TypeCapability is a class level annotation.
 * 
 * Type capabilities are useful for specifying the input and output
 * types of analysis engines.
 * 
 * See: https://uima.apache.org/d/uimafit-2.0.0/api/org/apache/uima/fit/descriptor/TypeCapability.html
 *
 */
@TypeCapability(
	outputs = {"it.unitn.types.ReverseToken"} 
)
/**
 * This class implements an analysis engine and it:
 * 1) extends the JCasAnnotator_ImplBase class
 * 2) implements the process method which takes the tokens from a Cas and stores additional annotations in it
 * 
 * All uimaFit analysis engines implements the JCasAnnotator_ImplBase class.
 * 
 * All analysis engines have a process method which must contain the annotation logic.
 * The Cas containing the current document, and possibly annotations from previous analysis engines in
 * the pipeline, is passed as input to the analysis engine.
 * 
 * The job of the analysis engine is to extract the document text and annotations from the Cas,
 * to do some processing, and store new annotations in the Cas.
 * 
 * Here we are just reversing the strings of the tokens. Please note that it is just a dummy example.
 * The real take-away is how to create a custom annotator from scratch. 
 */
public class ReverseTokenizer extends org.apache.uima.fit.component.JCasAnnotator_ImplBase {
	
	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		/**
		 * We retrieve and iterate over the tokens contained in the Cas.
		 * 
		 * We assume the Cas contains annotations of type Token,
		 * i.e., a tokenizer was previously run by the pipeline.
		 * 
		 * For information about the select function of JCasUtil see:
		 * http://uima.apache.org/d/uimafit-2.0.0/api/org/apache/uima/fit/util/JCasUtil.html
		 */
		for (Token token : JCasUtil.select(cas, Token.class)) {
			/**
			 * We retrieve the text spanned by the token.
			 */
			String text = token.getCoveredText();
			
			/**
			 * We reverse the string.
			 */
			String reversedText = new StringBuilder(text).reverse().toString();
			
			/**
			 * We create a new annotation of type ReverseToken.
			 */
			ReverseToken revToken = new ReverseToken(cas);
			
			/**
			 * We set the begin and end offset of the annotation to
			 * match the properties of the original token.
			 */
			revToken.setBegin(token.getBegin());
			revToken.setEnd(token.getEnd());
			
			/**
			 * We fill the proper field of our annotation with the reversed text.
			 */
			revToken.setReversedToken(reversedText);
			
			/**
			 * Important: we call the addToIndexes method which actually adds the
			 * annotation into the Cas.
			 */
			revToken.addToIndexes(cas);
		}
	}
} 
