package com.hans.shilipiaoxiang.applet.service;

import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShoppingCartService {
    Boolean insertGood(int cartId,int goodId,double price,int total);

    Boolean addGood(int cartId,int goodId,int num,double price,int total);

    Boolean subGood(int cartId,int goodId,int num,double price,int total);

    Boolean deleteGood(int cartId,int goodId);

    List<CCartGoods> getCartGoods(int cartId);

    List<CGoods> getCommitCartGoods(int cartId);

    Boolean deleteCartGoods(int cartId);
}
