public class SumFloat {
    public static void main(String[] args) {
        float sum = 0; // инициализируем сумму - будущий ответ
        for (int i = 0; i < args.length; i++) {   
            String stringPart = args[i]; // считываем часть входного аргумента
            int startPos = 0;
            int endPos = 0;
            boolean flag = true;
            for (int j = 0; j < stringPart.length(); j++){
                if ( Character.isWhitespace(stringPart.charAt(j)) ) {
                    if (endPos != startPos) {
                        sum += Float.parseFloat( stringPart.substring(startPos, endPos) );
                    }
                    startPos = j + 1;
                    flag = false;
                } else {
                    flag = true;
                }    
                endPos = j + 1;     
            }
            if (flag) {
                sum += Float.parseFloat( stringPart.substring(startPos, endPos) );
            }
        }
        System.out.println(sum); // вывод получившейся суммы
    }
}