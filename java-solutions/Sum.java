public class Sum {
    public static void main(String[] args) {
        int sum = 0; // инициализируем сумму - будущий ответ
        for (int i = 0; i < args.length; i++) {   
            String stringPart = args[i]; // считываем часть входного аргумента
            int startPos = 0; // флаг начала числа
            int endPos = 0; // флаг конца числа
            boolean flag = true; // костыль для суммы, если последнее число не сложилось :)
            for (int j = 0; j < stringPart.length(); j++){
                if ( Character.isWhitespace(stringPart.charAt(j)) ) {
                    if (endPos != startPos) {
                        sum += Integer.parseInt( stringPart.substring(startPos, endPos) ); // добавляем в сумму
                    }
                    startPos = j + 1; // двигаем начало строки на след символ 
                    flag = false; // костыльный флаг
                } else {
                    flag = true; // костыльный флаг
                }    
                endPos = j + 1; // каждую итерацию двигаем конец строки    
            }
            if (flag) {
                sum += Integer.parseInt( stringPart.substring(startPos, endPos) ); // добавляем в сумму
            }
        }
        System.out.println(sum); // вывод получившейся суммы
    }
}