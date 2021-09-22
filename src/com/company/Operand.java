package com.company;

public class Operand {
        TypeOp name;
        Type SystemS;
        Integer Count;

        enum TypeOp {
            SUMMAND,        // слагаемое
            REDUCE,         // уменьшаемое
            DEDUCTIBLE,     // вычитаемое
            MULTIPLIER,     // множитель
            DIVISIBLE,      // делимое
            DIVISOR,        // делитель
            AMOUNT,         // сумма
            DIFFERENCE,     // разность
            COMPOSITION,    // произведение
            PRIVATE         // частное
        }

        enum Type {
            ROM,            // римские
            ARAB            // арабские
        }

        static class OperandException extends Exception{
            public OperandException(String message){
                super(message);
            }
        }

        public static void Action_Operands(String op1, String act, String op2) throws OperandException {
            com.company.Operand a1 = new com.company.Operand();
            com.company.Operand a2 = new com.company.Operand();
            com.company.Operand a3 = new com.company.Operand();

            switch (act) {
                case "+" -> {
                    a1.name = TypeOp.SUMMAND;
                    a2.name = TypeOp.SUMMAND;
                    a3.name = TypeOp.AMOUNT;
                }
                case "-" -> {
                    a1.name = TypeOp.REDUCE;
                    a2.name = TypeOp.DEDUCTIBLE;
                    a3.name = TypeOp.DIFFERENCE;
                }
                case "*" -> {
                    a1.name = TypeOp.MULTIPLIER;
                    a2.name = TypeOp.MULTIPLIER;
                    a3.name = TypeOp.COMPOSITION;
                }
                case "/" -> {
                    a1.name = TypeOp.DIVISIBLE;
                    a2.name = TypeOp.DIVISOR;
                    a3.name = TypeOp.PRIVATE;
                }
                default -> throw new OperandException("Введенная строка не является математической операцией");
            }

            String[] rom_char_list = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab_char_list = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            for (int i = 0; rom_char_list.length > i; i++) {
                if (rom_char_list[i].equals(op1)) {
                    a1.SystemS = Type.ROM;
                    a1.Count = i + 1;
                    break;
                } else {
                    if (arab_char_list[i].equals(op1)) {
                        a1.SystemS = Type.ARAB;
                        a1.Count = i + 1;
                        break;
                    }
                }
            }

            for (int j = 0; arab_char_list.length > j; j++) {
                if (rom_char_list[j].equals(op2)) {
                    a2.SystemS = Type.ROM;
                    a2.Count = j + 1;
                    break;
                } else {
                    if (arab_char_list[j].equals(op2)) {
                        a2.SystemS = Type.ARAB;
                        a2.Count = j + 1;
                        break;
                    }
                }
            }

            if (a1.SystemS == a2.SystemS) {
                a3.SystemS = a1.SystemS;
            if (a1.name == TypeOp.SUMMAND & a2.name == TypeOp.SUMMAND) {
                a3.Count = a1.Count + a2.Count;
            } else {
                if (a1.name == TypeOp.REDUCE & a2.name == TypeOp.DEDUCTIBLE) {
                    a3.Count = a1.Count - a2.Count;
                } else {
                    if (a1.name == TypeOp.MULTIPLIER & a2.name == TypeOp.MULTIPLIER) {
                        a3.Count = a1.Count * a2.Count;
                    } else {
                        a3.Count = a1.Count / a2.Count;
                    }
                }
            }
            }
            else {
                throw new OperandException("Используются одновременно разные системы счисления");
            }

            if (a3.SystemS == Type.ROM) {
                int ArabNumber = a3.Count;
                if (ArabNumber < 0) throw new OperandException("Результат вычислений отрицательный, в римской системе нет отрицательных чисел");
                int[] arab_value_list = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
                String[] rom_ch_list = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
                StringBuilder res = new StringBuilder();
                for (int m = 0; m < arab_value_list.length; m++) {
                    while (ArabNumber >= arab_value_list[m]) {
                        ArabNumber -= arab_value_list[m];
                        res.append(rom_ch_list[m]);
                    }
                }

                System.out.print("Результат вычислений: " + res);

            } else {
                System.out.println("Результат вычислений: " + a3.Count);
            }
        }
    }




