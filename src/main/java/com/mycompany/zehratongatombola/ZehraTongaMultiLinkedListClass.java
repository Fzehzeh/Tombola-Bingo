package com.mycompany.zehratongatombola;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JLabel;
import java.util.ArrayList;

public class ZehraTongaMultiLinkedListClass {

    public int size;
    public ZehraTongaNodeClass head;

    public ZehraTongaMultiLinkedListClass() {
        this.head = null;

    }

    // Kartın başlangıç düğümünü belirleyen metot
    public void setHead(ZehraTongaNodeClass head) {
        this.head = head;
    }

    //  listeye yeni bir numara ekleme 
    public void add(int data) {
        ZehraTongaNodeClass newNode = new ZehraTongaNodeClass(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ZehraTongaNodeClass current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    //  listeden bir sayıyı kaldırma 
    public void delete(int data) {
        if (head == null) {
            return;
        }
        ZehraTongaNodeClass current = head;
        ZehraTongaNodeClass previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return;
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;

        }
        size--;
    }

    // Belirli bir indeksteki düğümü kaldırma
    public void deleteAt(int index) {
        if (head == null || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        ZehraTongaNodeClass current = head;
        ZehraTongaNodeClass previous = null;
        int currentIndex = 0;
        while (current != null && currentIndex != index) {
            previous = current;
            current = current.next;
            currentIndex++;
        }
        if (current != null) {
            previous.next = current.next;
        }
        size--;
    }

    // Belirli bir indeksteki düğümün değerini döndüren yöntem
    public int get(int index) {
        if (head == null || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        ZehraTongaNodeClass current = head;
        int currentIndex = 0;
        while (current != null && currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return current.data;
    }

    // listenin belirli bir sayı içerip içermediğini kontrol etme
    public boolean include(int data) {
        ZehraTongaNodeClass current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Bağlantılı listeyi yazdıran metod
    public void printList() {
        ZehraTongaNodeClass current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean hasMatch(int randomNumber) {
        ZehraTongaNodeClass current = head;
        while (current != null) {
            if (current.isMatch(randomNumber)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public int checkCinko() {
        ZehraTongaNodeClass current = head;
        int patternIndex = 0;
        int cinkoCount = 0;
        int checkCount = 0;

        if (head == null) {
            System.out.println("Head is null!!!!");
        }
        // İlk while döngüsü (patternIndex < 5)
        while (current != null && patternIndex < 5) {
            if (current.isChecked) {
                checkCount++;
            }
            patternIndex++;
            current = current.next;
        }
        System.out.println("");
        if (checkCount == 5) {
            cinkoCount++;
        }

        checkCount = 0;
        patternIndex = 0;
        // İkinci while döngüsü (patternIndex < 10)
        while (current != null && patternIndex < 5) {
            if (current.isChecked) {
                checkCount++;
            }

            patternIndex++;
            current = current.next;
        }
        if (checkCount == 5) {
            cinkoCount++;
        }

        checkCount = 0;
        patternIndex = 0;
        // Üçüncü while döngüsü (patternIndex < 15)
        while (current != null && patternIndex < 5) {
            if (current.isChecked) {
                checkCount++;
            }
            patternIndex++;
            current = current.next;
        }
        if (checkCount == 5) {
            cinkoCount++;
        }

        return cinkoCount;
    }

    void markAsChecked(int randomNumber) {
        ZehraTongaNodeClass current = head;
        while (current != null && current.data != randomNumber) {
            current = current.next;
        }

        if (current != null) {
            current.isChecked = true;
            System.out.println("Checked");
        }
    }

}
