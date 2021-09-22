package com.company;

import java.util.Scanner;
public class Main {

        static String op1;
        static String op2;
        static String op3;
        static String act;

        public static void main(String[] args) throws Exception {

            Scanner str = new Scanner(System.in);
            System.out.print("Введите выражение для вычисления (операнд1_пробел_знак операции_пробел_операнд2): ");
            op1 = str.next();
            act = str.next();
            op2 = str.next();


                com.company.Operand.Action_Operands (op1, act, op2);



            }

        }


