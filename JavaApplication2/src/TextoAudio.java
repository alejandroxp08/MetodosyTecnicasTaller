

import com.sun.speech.freetts.VoiceManager;
import java.io.*;
import com.sun.speech.freetts.*;

public class TextoAudio {

    private static final String VOICE_NAME_KEVIN = "kevin16";
     private Voice voice;
    public TextoAudio() {

        VoiceManager vm = VoiceManager.getInstance(); 
        voice = vm.getVoice(VOICE_NAME_KEVIN);
        voice.allocate();
    }

    public   void speak(String inputText) {

        if(inputText != null && !inputText.isEmpty()) {

            voice.speak(inputText);
        }
    }
    

}