package com.hans.shilipiaoxiang.applet.service.serviceImpl;

import com.hans.shilipiaoxiang.applet.mapper.CCartGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.CShoppingCartMapper;
import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CShoppingCart;
import com.hans.shilipiaoxiang.applet.service.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartImpl implements ShoppingCart {
    @Autowired
    private CShoppingCartMapper cShoppingCartMapper;
    @Autowired
    private CCartGoodsMapper cCartGoodsMapper;
    @Override
    public Boolean insertGood(int cartId, int goodId,double price,int total) {
//        int id=cShoppingCartMapper.selectByOpenId(cartId);
        CCartGoods cCartGoods=new CCartGoods();
        cCartGoods.setCartId(cartId);
        cCartGoods.setGoodId(goodId);
        cCartGoods.setNum(1);
        int flag1=cCartGoodsMapper.insert(cCartGoods);
        CShoppingCart cShoppingCart=new CShoppingCart();
        cShoppingCart.setId(cartId);
        cShoppingCart.setTotal(total);
        cShoppingCart.setPrice(price);
        int flag2=cShoppingCartMapper.updateByPrimaryKeySelective(cShoppingCart);
        if(flag1!=0&&flag2!=0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean addGood(int cartId, int goodId, int num, double price, int total) {
        CCartGoods cCartGoods=new CCartGoods();
        cCartGoods.setCartId(cartId);
        cCartGoods.setGoodId(goodId);
        cCartGoods.setNum(num);
        int flag1=cCartGoodsMapper.update(cCartGoods);
        CShoppingCart cShoppingCart=new CShoppingCart();
        cShoppingCart.setId(cartId);
        cShoppingCart.setTotal(total);
        cShoppingCart.setPrice(price);
        int flag2=cShoppingCartMapper.updateByPrimaryKeySelective(cShoppingCart);
        if(flag1!=0&&flag2!=0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean subGood(int cartId, int goodId, int num, double price, int total) {
        CCartGoods cCartGoods=new CCartGoods();
        cCartGoods.setCartId(cartId);
        cCartGoods.setGoodId(goodId);
        cCartGoods.setNum(num);
        int flag1=cCartGoodsMapper.update(cCartGoods);
        CShoppingCart cShoppingCart=new CShoppingCart();
        cShoppingCart.setId(cartId);
        cShoppingCart.setTotal(total);
        cShoppingCart.setPrice(price);
        int flag2=cShoppingCartMapper.updateByPrimaryKeySelective(cShoppingCart);
        if(flag1!=0&&flag2!=0)
            return true;
        else
            return false;
    }

    @Override
    public Boolean deleteGood(int cartId, int goodId) {
        CCartGoods cCartGoods=new CCartGoods();
        cCartGoods.setCartId(cartId);
        cCartGoods.setGoodId(goodId);
        CCartGoods cCartGoods1=cCartGoodsMapper.selectByIds(cCartGoods);
        int flag=cCartGoodsMapper.deleteByPrimaryKey(cCartGoods1.getId());
        if(flag!=0)
            return true;
        else
            return false;
    }
}
