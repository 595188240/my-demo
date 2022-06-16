package com.my.lambda;

/**
 * @author ffdeng2
 * @date 2022-5-8 20:44
 */
public class demo {

    public static void main(String[] args) {
        // lambda表达式中的参数类型都是由编译器推断得出的

        String name = "ffdeng";
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(name + " test lambda ");
            }
        }).start();

        // 既成事实上必须是final
        //name = "ffdeng2";

        //Comparator
    }

}
