package com.hans.shilipiaoxiang.applet.service;

public interface ShoppingCart {
    Boolean insertGood(int cartId,int goodId,double price,int total);

    Boolean addGood(int cartId,int goodId,int num,double price,int total);

    Boolean subGood(int cartId,int goodId,int num,double price,int total);

    Boolean deleteGood(int cartId,int goodId);
}
