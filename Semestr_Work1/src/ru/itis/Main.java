package ru.itis;

public class Main {

    public static void main(String[] args) {
        String str = "X1X2-X4VX2X5VX2-X3-X5VX4";
        DNF dnf = new DNF(str);
        System.out.println("строковое представление ДНФ : ");
        System.out.println(dnf);
        System.out.println();

        DNF.Konj konj = new DNF.Konj();
        konj.add("X4X5");
        System.out.println("вставка конъюнкции в ДНФ :");
        dnf.insert(konj);
        System.out.println(dnf);
        System.out.println();

        System.out.println("построить дизъюнкцию двух ДНФ :");
        String str1 = "X3-X5VX2X5VX1X2V-X1X2";
        DNF dnf1 = new DNF(str1);
        System.out.println(dnf);
        System.out.println(dnf1);
        DNF dnf2 = dnf.disj(dnf1);
        System.out.println(dnf2);
        System.out.println();

        System.out.println("вычислить значение ДНФ на наборе v :");
        boolean[] v = {true, true, false, true, false};
        System.out.println(dnf.value(v));
        System.out.println();

        System.out.println("упорядочить список конъюнкций по возрастанию длины : ");
        dnf2.sortByLenght();
        System.out.println(dnf2);
        System.out.println();

        System.out.println("построить новую ДНФ, в которой все конъюнкции содержат переменную с номером i :");
        DNF dnf3 = new DNF("X1VX2VX2X3");
        System.out.println(dnf3.dnfWith(2));

        int i = 0;
    }
}
