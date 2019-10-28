package ru.spsuace.homework2.objects.october2;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Правила на '-' является валидность числа. --3 не валидно. -3e-1 валдино
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же.
     *
     * Работайте со строкой, НЕ надо ее переводить в массив байт (это можно использовать только для цикла)
     * У класса Character есть полезные методы, например Character.isDigit()
     */
    public static Number simpleValueOf(String str) {
        if (str == null || str == "") {
            return null;
        }
        String[] strCopy = new String[str.length()];
        String strNewLine = "";

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).matches("[-e.]*[0-9]*")) {
                strNewLine += str.charAt(i);
            }
        }

        if (!strNewLine.matches("-?[0-9]+")){
            if (strNewLine.matches("-?[0-9]+\\.[0-9]+") || strNewLine.matches("-?([0-9]+\\.[0-9]+|[0-9]+)e-?[0-9]+")){
                return Double.valueOf(strNewLine);
            }
            return null;
        }

        if ((Long.valueOf(strNewLine) > Integer.MAX_VALUE) || (Long.valueOf(strNewLine) < Integer.MIN_VALUE)) {
                return Long.valueOf(strNewLine);
        }
        return Integer.valueOf(strNewLine);
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
