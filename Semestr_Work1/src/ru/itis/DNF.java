package ru.itis;


import java.util.Comparator;

public class DNF implements Collection {



    public static class Konj implements Comparable<Konj> {
        private static final int DEFAULT_SIZE = 5;
        private int variables[];
        private int count;
        private Konj next;
        private String value;


        public Konj() {
            this.variables = new int[DEFAULT_SIZE];
            this.count = 0;
        }

        public void add(String k) {
            value = k;
            char[] array = k.toCharArray();
            int sign = 1;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 'X') continue;
                if (array[i] == '-') {
                    sign = -1;
                    continue;
                }
                this.variables[count++] = Character.getNumericValue(array[i]) * sign;
                if (sign < 0) sign = 1;

            }

        }

        public int getCount() {
            return count;
        }

        public Konj getNext() {
            return next;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int compareTo(Konj o) {
            return this.count - o.count;
        }
    }

    private Konj head;
    private Konj tail;
    private int count;

    public Konj getHead() {
        return head;
    }

    public Konj getTail() {
        return tail;
    }

    public int getCount() {
        return count;
    }
    // посстроение по заданной строке

    public DNF() {
        this.count = 0;
    }

    DNF(String s) {
        add(s);
    }

    @Override
    public void add(String k) {
        String[] array = k.split("V");
        for (int i = 0; i < array.length; i++) {
            Konj newKonj = new Konj();
            newKonj.add(array[i]);
            if (head == null) {
                head = newKonj;
                tail = newKonj;
            } else {
                tail.next = newKonj;
                tail = newKonj;
            }
            count++;
        }

    }

    public void addKonj(Konj k) {
        Konj konj = new Konj();
        konj.add(k.value);
        if (head == null) {
            head = konj;
            tail = konj;
        } else {
            tail.next = konj;
            tail = konj;
        }
        count++;
    }

    // строковое представление +
    public String toString() {
        Konj current = head;
        StringBuilder dnf = new StringBuilder();
        while (current.next != null) {
            dnf.append(current.value + " V ");
            current = current.next;
        }
        dnf.append(current.value);
        return dnf.toString();
    }

    // вставка конъюнкции в ДНФ, при вставке учесть существует ли подобный элемент в списке
    public void insert(Konj k) {
        Konj current = head;
        boolean flag = false;
        while (current != null && !flag) {
            if (k.value.equals(current.value)) flag = true;
            current = current.next;
        }
        if (!flag) {
            addKonj(k);
        }
    }

    //построить дизъюнкцию двух ДНФ. Удалить повторяющиеся элементы
    public DNF disj(DNF d) {
        DNF newDNF = new DNF();
        Konj currentThisDNF = head;
        while (currentThisDNF != null) {
            newDNF.addKonj(currentThisDNF);
            currentThisDNF = currentThisDNF.next;
        }
        Konj currentD = d.head;
        while (currentD != null) {
            currentThisDNF = head;
            while (currentThisDNF != null && !currentD.value.equals(currentThisDNF.value)) {
                currentThisDNF = currentThisDNF.next;
            }
            if (currentThisDNF == null) newDNF.addKonj(currentD);
            currentD = currentD.next;
        }
        return newDNF;
    }


    //вычислить значение ДНФ на наборе v
    public boolean value(boolean[] v) {
        //11010
        //01234
        boolean value = false;
        Konj current = head;
        while (current != null) {
            boolean f = true;
            for (int i = 0; i < current.count; i++) {
                boolean val = v[Math.abs(current.variables[i]) - 1];
                if (current.variables[i] < 0) val = !val;
                f = val && f;
                if (f == false) break;
            }
            value = f || value;
            if (value == true) break;
            current = current.next;
        }
        return value;
    }

    //упорядочить список конъюнкций по возрастанию длины
    public void sortByLenght() {
        DNF[] stack = new DNF[32];
        int currentPosition = 1;
        Konj current = head;
        stack[0] = new DNF();
        stack[0].addKonj(current);
        while (current.next != null) {
            stack[currentPosition] = new DNF();
            current = current.next;
            stack[currentPosition].addKonj(current);
            while (currentPosition != 0 && stack[currentPosition - 1].count == stack[currentPosition].count) {
                stack[currentPosition - 1] = stack[currentPosition - 1].merge(stack[currentPosition]);
                stack[currentPosition] = null;
                currentPosition--;
            }
            currentPosition++;
        }
        for (int i = currentPosition - 1; i > 0; i--) {
            stack[i - 1] = stack[i - 1].merge(stack[i]);
        }
        head = stack[0].head;
        tail = stack[0].tail;

    }

    private DNF merge(DNF second) {
        DNF newDNF = new DNF();
        Konj currentFirst = head;
        Konj currentSecond = second.head;
        while (currentFirst != null && currentSecond != null) {
            if (currentFirst.compareTo(currentSecond) < 0) {
                newDNF.addKonj(currentFirst);
                currentFirst = currentFirst.next;

            } else {
                newDNF.addKonj(currentSecond);
                currentSecond = currentSecond.next;
            }
        }
        if (currentFirst != null) {
            while (currentFirst != null) {
                newDNF.addKonj(currentFirst);
                currentFirst = currentFirst.next;
            }
        } else {
            while (currentSecond != null) {
                newDNF.addKonj(currentSecond);
                currentSecond = currentSecond.next;
            }
        }
        return newDNF;

    }


    //построить новую ДНФ, в которой все конъюнкты содержат переменную с номером i
    public DNF dnfWith(int i) {
        DNF newDNF = new DNF();
        Konj current = head;
        while (current != null) {
            for (int j = 0; j < current.count; j++) {
                if (Math.abs(i) == Math.abs(current.variables[j])) {
                    newDNF.add(current.value);
                    break;
                }
            }
            current = current.next;
        }
        return newDNF;
    }


}

