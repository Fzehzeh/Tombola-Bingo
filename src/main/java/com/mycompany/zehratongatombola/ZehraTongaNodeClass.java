package com.mycompany.zehratongatombola;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class ZehraTongaNodeClass {

    public int data;
    public boolean isChecked;
    public ZehraTongaNodeClass next;
    private JLabel label; //
    //public ZehraTongaNodeClass nextRow;
    public ZehraTongaNodeClass  head;
    ZehraTongaNodeClass nextRow;
    
    
    public ZehraTongaNodeClass(int data) {
        this.data = data;
        this.next = null;
        this.label = new JLabel(Integer.toString(data));
    }

    public int getData() {
        return data;
    }

    public ZehraTongaNodeClass getNext() {
        return next;
    }

    public void setNext(ZehraTongaNodeClass next) {
        this.next = next;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabelColor(Color color) {
        label.setBackground(color);
    }

   
    public boolean isMatch(int randomNumber) {
        return this.data == randomNumber;
    }
    

 public boolean checkCinko(ArrayList<Integer> pattern) {
    ZehraTongaNodeClass current = this;
    int patternIndex = 0;
    while (current != null && patternIndex < pattern.size()) {
        if (current.data == Integer.parseInt(Integer.toString(current.data))) {
            patternIndex++;
        }
        current = current.next;
    }
    return patternIndex == pattern.size();
} 

   
public boolean checkRowMatch() {
    ZehraTongaNodeClass current = this; // Başlangıç düğümü
    int lastData = current.data; // İlk düğümün verisi
    current = current.next; // Sonraki düğüme geç
    
    while (current != null) {
        // Eğer sonraki düğümün verisi ilk düğümle aynı değilse, eşleşme yok demektir
        if (current.data != lastData) {
            return false;
        }
        
        current = current.next; // Sonraki düğüme geç
    }
    
    // Tüm bloklar eşleşiyorsa true döndür
    return true;
}

   
}
