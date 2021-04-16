package com.my.demo.decorator;

/**
 * Date        Author        Version        Comments
 * 2021/4/16     ffdeng         1.0       Initial Version
 **/
public class TShirts extends Finery {

    @Override
    public void Show() {
        System.out.print("大T恤 ");
        super.Show();
    }

}
