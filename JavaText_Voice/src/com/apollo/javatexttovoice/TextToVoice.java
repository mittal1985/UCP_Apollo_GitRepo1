package com.apollo.javatexttovoice;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TextToVoice {
	String speaktext; 
	public void dospeak(String speak,String  voicename)    
	{}    

	public static void main(String[] args)    
	{ 
		try{
		System.setProperty("freetts.voices",  "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
    
	   Central.registerEngineCentral
	    ("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
	   Synthesizer  synthesizer = 
	    Central.createSynthesizer(new SynthesizerModeDesc(Locale.ENGLISH));
	   synthesizer.allocate();
	   synthesizer.resume();
	   synthesizer.speakPlainText("HELLO hi UCP team , how are you!! doing well, work hard and thanks for calling UCP team", null);
	   synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	   synthesizer.deallocate();
	   }catch(Exception exception){
		   exception.printStackTrace();
	   }
}
}