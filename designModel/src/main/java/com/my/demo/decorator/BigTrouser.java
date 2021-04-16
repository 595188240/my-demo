package com.my.demo.decorator;

/**
 * Date        Author        Version        Comments
 * 2021/4/16     ffdeng         1.0       Initial Version
 **/
public class BigTrouser extends  Finery {

    @Override
    public void Show() {
        System.out.print("垮裤 ");
        super.Show();
    }

}
