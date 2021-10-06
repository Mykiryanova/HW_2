public class Exception extends Throwable {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        // Массив с верным количеством столбцов и не верным количеством строк
        String arr[][] = {{"we", "df", "2", "1"}, {"1", "2", "8", "%"}};
        // Массив с верным количеством строк и не верным количеством столбцов
        String arr0[][] = {{"3", "4", "5"}, {"n", "$", "e"}, {"3", "4", "90"}, {"1", "2", "6"}};
        //Массив у которого все неверное
        String arr1[][] = {{"3", "4"}, {"1", "2"}};
        //Массив у которого все верное
        String arr2[][] = {{"3", "4", "2", "0"}, {"1", "2", "8", "5"}, {"3", "4", "2", "5"}, {"1", "2", "5", "1"}};
        //Массив у которого все верное
        String arr3[][] = {{"b", "4", "2", "0"}, {"1", "2", "8", "5"}, {"3", "4", "2", "5"}, {"1", "2", "a", "1"}};


        System.out.println("Проверим массив 2х2 - неверное количество строк и столбцов ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        try {
            methodArray(arr1);
        } catch (
                Exception.MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Ошибка! Необходимо задать массив 4х4");
        }




        System.out.println();
        System.out.println("Проверим массив 4х4");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        try {
            methodArray(arr2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Необходимо задать массив 4х4");
        }
        System.out.println();
        System.out.println("Проверим массив 4х4");
        for(int i=0; i<arr3.length; i++){
            for(int j=0; j<arr3[i].length; j++){
                System.out.print(arr3[i][j]+" ");
            }
            System.out.println();
        }
        try {
            methodArray(arr3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Необходимо задать массив 4х4");
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Проверьте правильность ввода данных! Необходимо задать целочисленный массив 4х4.");
        }

    }

    public static int methodArray (String [][] myArray1) throws MyArraySizeException, MyArrayDataException {
        String[][] myArray = new String[4][4]; // После того как написала код, задумалась, а нужно ли было вообще это писать, но код работает и я побоялась его менять)))
                                               // так как и так потратила на выполнение дз несколько дней. Вроде бы и легко, но не хватает практики по самому простому. Опять вспоминала циклы, массивы и прочее

        if (myArray1.length != myArray.length) throw new MyArraySizeException();
            for(int i=0; i<4; i++) {
                if (myArray1[i].length != 4)
                    throw new MyArraySizeException();

            }
        System.out.println("Поздравляю! Вы ввели массив 4х4!");

    System.out.println("Теперь преобразуем строковый массив в int и посчитаем сумму элементов");

        for(int i=0; i< myArray1.length; i++) {
            for (int j = 0; j < myArray1[i].length; j++) {
                if (Character.isDigit(Integer.parseInt(myArray1[i][j]))) throw new MyArrayDataException();
            }
        }

    int[][] myArrayInt = new int [4][4];
    for(int i=0; i< myArray.length; i++){
        for(int j=0; j<myArray1[i].length; j++){
            myArrayInt[i][j] = Integer.parseInt(myArray1[i][j]);
        }
    }


        int summ = 0;
        for(int i=0; i< myArrayInt.length; i++){
            for(int j=0; j<myArrayInt[i].length; j++){
            summ += myArrayInt[i][j];
        }
    }
        System.out.println ("Сумма элементов равна " + summ);
        return summ;
    }

    public static class MyArraySizeException extends Exception{
    }
    public static class MyArrayDataException extends NumberFormatException{
    }

    }




