package edu.upv.poo;

import java.security.SecureRandom;
import javax.swing.*;

public class GeneradorRandomsSW 
        extends SwingWorker<float[], Integer> {

    private final int cantNumeros;
    private final JTextArea txt;
    private final SecureRandom secRan =
            new SecureRandom();
    
    public GeneradorRandomsSW(
            int cantNumeros, JTextArea txt) {
        this.cantNumeros = cantNumeros;
        this.txt = txt;
    }
    
    @Override
    protected float[] doInBackground() {
        
        System.out.println(
                "doInBackground on thread " +
                Thread.currentThread().getName());
        float[] randoms = new float[cantNumeros];
        setProgress(0);
        
        for (int i = 0; i < cantNumeros; i++) {
            if (isCancelled()) return randoms;
            randoms[i] = secRan.nextFloat();
            txt.append("" + randoms[i] + "\n");
            setProgress(100 * (i + 1) / cantNumeros);
        }
        
        return randoms;
        
    }
    
    
    
}
