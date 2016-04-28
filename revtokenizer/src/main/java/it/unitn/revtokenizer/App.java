package it.unitn.revtokenizer;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordSegmenter;
import it.unitn.types.ReverseToken;

public class App {
	
    public static void main(String[] args) throws UIMAException {
    	JCas cas = JCasFactory.createJCas();
    	
    	cas.setDocumentText("The apple is on the table.");
    	cas.setDocumentLanguage("en");
    	
    	AnalysisEngine segmenter =
    			AnalysisEngineFactory.createEngine(
    					StanfordSegmenter.class);
    	
    	AnalysisEngine reverseTokenizer =
    			AnalysisEngineFactory.createEngine(
    					ReverseTokenizer.class);
    	
    	SimplePipeline.runPipeline(cas,
    			segmenter, reverseTokenizer);
    	
    	for (ReverseToken token : JCasUtil.select(cas, ReverseToken.class)) {
    		System.out.println(token.getCoveredText() +
    				" " + token.getReversedToken());
    	}
     
    }
}












