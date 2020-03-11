package com.hans.shilipiaoxiang.applet.service.serviceImpl;

import com.hans.shilipiaoxiang.applet.mapper.CCartGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.CGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.COrderGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.COrderMapper;
import com.hans.shilipiaoxiang.applet.pojo.CCartGoods;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.COrder;
import com.hans.shilipiaoxiang.applet.pojo.COrderGoods;
import com.hans.shilipiaoxiang.applet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CCartGoodsMapper cCartGoodsMapper;
    @Autowired
    private COrderMapper cOrderMapper;
    @Autowired
    private COrderGoodsMapper cOrderGoodsMapper;
    @Autowired
    private CGoodsMapper cGoodsMapper;
    @Override
    public List<CCartGoods> getGoodsId(int cartId) {
        List<CCartGoods> cCartGoodsList=cCartGoodsMapper.getGoodsId(cartId);
//        List<Integer> list=new ArrayList<>();
//        for(CCartGoods c:cCartGoodsList){
//            list.add(c.getGoodId());
//        }
        return cCartGoodsList;
    }

    @Override
    public int addOrder(COrder cOrder) {
        cOrderMapper.insert(cOrder);
        return cOrder.getId();
    }

    @Override
    public int addOrderGoods(COrderGoods cOrderGoods) {
        cOrderGoodsMapper.insert(cOrderGoods);
        return cOrderGoods.getId();
    }

    @Override
    public List<CGoods> getGoodsName(int orderId) {
        List<CGoods> cGoods=cGoodsMapper.showOrderPreview(orderId);
        return cGoods;
    }

    @Override
    public COrder getOrder(int orderId) {
        COrder cOrder=cOrderMapper.selectByPrimaryKey(orderId);
        return cOrder;
    }

    @Override
    public COrder getOrderDetail(int orderId) {
        COrder cOrder=cOrderMapper.showOrder(orderId);
        return cOrder;
    }

    @Override
    public List<COrder> getOrders(COrder cOrder) {
        List<COrder> cOrderList=cOrderMapper.showOrders(cOrder);
        return cOrderList;
    }
}
