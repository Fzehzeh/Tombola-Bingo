package com.mycompany.zehratongatombola;

import java.awt.GridLayout;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZehraTongaMainTombola {

    static Random random = new Random();

    public static ZehraTongaMultiLinkedListClass generatePlayerCards() {
          ZehraTongaMultiLinkedListClass card = new ZehraTongaMultiLinkedListClass();
          int minNum = 1;
          int maxNum = 9;
          
          
    for (int row = 0; row < 3; row++) {
        ZehraTongaNodeClass rowStartNode = null; // Her satırın ilk düğümü

        for (int col = 0; col < 9; col++) {
            int randomNumber = random.nextInt(minNum + col * 10, maxNum + col * 10 + 1);
            while (card.include(randomNumber)) {
                randomNumber = random.nextInt(minNum + col * 10, maxNum + col * 10 + 1);
            }

            // Yeni düğümü oluştur ve kart listesine ekle
            card.add(randomNumber);

            if (rowStartNode == null) {
                rowStartNode = card.head; // İlk düğümü belirle
            }
        }

        // Satırın son düğümü ile bir sonraki satırın ilk düğümünü bağla
        if (row < 2 && card.head != null) {
            ZehraTongaNodeClass current = card.head;
            while (current.next != null) {
                current = current.next; // Satırın son düğümüne git
            }
            current.nextRow = card.head.next; // Bir sonraki satırın ilk düğümüne bağla
        }
    }

      card.printList();

       
        
        for (int row = 0; row < 3; row++) {
            ZehraTongaMultiLinkedListClass markedIndexes = new ZehraTongaMultiLinkedListClass();
            int numX = 0;
            while (numX < 4) {
                int randomIndex = random.nextInt(9-numX);
                card.deleteAt(randomIndex + (row * 5));
               numX++;
            }
            
        }

        return card;

    }

   }


