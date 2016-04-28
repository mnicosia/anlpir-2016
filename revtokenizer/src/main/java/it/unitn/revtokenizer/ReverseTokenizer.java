package it.unitn.revtokenizer;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.descriptor.TypeCapability;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import it.unitn.types.ReverseToken;

@TypeCapability(
	outputs = {"it.unitn.types.ReverseToken"} 
)

public class ReverseTokenizer extends org.apache.uima.fit.component.JCasAnnotator_ImplBase {

	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		for (Token token : JCasUtil.select(cas, Token.class)) {
			String text = token.getCoveredText();
			String reversedText = new StringBuilder(text).reverse().toString();
			
			ReverseToken revToken = new ReverseToken(cas);
			revToken.setBegin(token.getBegin());
			revToken.setEnd(token.getEnd());
			revToken.setReversedToken(reversedText);
			revToken.addToIndexes(cas);
		}
	} 
	  
} 
