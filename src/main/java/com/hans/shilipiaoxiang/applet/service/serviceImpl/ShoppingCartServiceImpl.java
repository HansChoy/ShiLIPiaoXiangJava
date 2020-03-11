package com.hans.shilipiaoxiang.applet.service.serviceImpl;

import com.hans.shilipiaoxiang.applet.mapper.CCartGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.CGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.CShoppingCartMapper;
import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.CShoppingCart;
import com.hans.shilipiaoxiang.applet.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private CShoppingCartMapper cShoppingCartMapper;
    @Autowired
    private CCartGoodsMapper cCartGoodsMapper;
    @Autowired
    private CGoodsMapper cGoodsMapper;
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
    public Boolean deleteGood(int cartId, int goodId,double price,int total) {
        CCartGoods cCartGoods=new CCartGoods();
        cCartGoods.setCartId(cartId);
        cCartGoods.setGoodId(goodId);
        CCartGoods cCartGoods1=cCartGoodsMapper.selectByIds(cCartGoods);
        int flag1=cCartGoodsMapper.deleteByPrimaryKey(cCartGoods1.getId());
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
    public List<CCartGoods> getCartGoods(int cartId) {
        List<CCartGoods> cCartGoodsList=cCartGoodsMapper.showCartGoods(cartId);
        return cCartGoodsList;
    }

    @Override
    public List<CGoods> getCommitCartGoods(int cartId) {
        List<CGoods> cGoodsList=cGoodsMapper.commitCartGoods(cartId);
        return cGoodsList;
    }

    @Override
    public Boolean deleteCartGoods(int cartId) {
        int flag = cCartGoodsMapper.deleteCartGoods(cartId);
        CShoppingCart cShoppingCart=new CShoppingCart();
        cShoppingCart.setId(cartId);
        cShoppingCart.setPrice(0.0);
        cShoppingCart.setTotal(0);
        cShoppingCartMapper.updateByPrimaryKeySelective(cShoppingCart);
        if(flag!=0)
            return true;
        else
            return false;
    }

    @Override
    public CShoppingCart getPriceAndTotal(int cartId) {
        CShoppingCart cShoppingCart=new CShoppingCart();
        cShoppingCart=cShoppingCartMapper.selectByPrimaryKey(cartId);
        return cShoppingCart;
    }

    @Override
    public CCartGoods getNum(int cartId, int goodId) {
        CCartGoods cCartGoods=new CCartGoods();
        cCartGoods.setCartId(cartId);
        cCartGoods.setGoodId(goodId);
        CCartGoods cCartGoods1=new CCartGoods();
        cCartGoods1=cCartGoodsMapper.getNum(cCartGoods);
        return cCartGoods1;
    }
}
