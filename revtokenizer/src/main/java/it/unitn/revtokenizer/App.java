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
    	/**
    	 * We create a new Cas that we will use for our analysis.
    	 */
    	JCas cas = JCasFactory.createJCas();

    	/**
    	 * We put inside the Cas the text that we want to analyze.
    	 */
    	cas.setDocumentText("The apple is on the table.");
    	
    	/**
    	 * We set the document language.
    	 * 
    	 * This step is good practice.
    	 * 
    	 * If you set the language an annotator may use this parameter
    	 * to instantiate a language specific model.
    	 * 
    	 * So the effect of this parameter ultimately depends on the
    	 * implementation of the analsys engine that you add in the pipeline.
    	 * Many analysis engines have language defaults, or accepts a
    	 * configuration parameter for selecting the language of the model.
    	 */
    	cas.setDocumentLanguage("en");
    	
    	/**
    	 * We instatiate a segmenter which can perform tokenization.
    	 */
    	AnalysisEngine segmenter =
    			AnalysisEngineFactory.createEngine(
    					StanfordSegmenter.class);
    	
    	/**
    	 * We instatiate our custom analyzer.
    	 */
    	AnalysisEngine reverseTokenizer =
    			AnalysisEngineFactory.createEngine(
    					ReverseTokenizer.class);
    	
    	/**
    	 * We run on the Cas a pipeline constituted by the tokenizer
    	 * and our custom analyzer.
    	 */
    	SimplePipeline.runPipeline(cas,
    			segmenter, reverseTokenizer);
    	
    	/**
    	 * After the analysis we retrieve our custom annotations and print
    	 * their values.    	
    	 */
    	for (ReverseToken token : JCasUtil.select(cas, ReverseToken.class)) {
    		System.out.println(token.getCoveredText() +
    				" " + token.getReversedToken());
    	}
    }
}












