package com.hans.shilipiaoxiang.applet.service;

import com.hans.shilipiaoxiang.applet.pojo.*;

import java.util.List;

public interface OrderService {
    List<CCartGoods> getGoodsId(int cartId);

    int addOrder(COrder cOrder);

    int addOrderGoods(COrderGoods cOrderGoods);

    List<CGoods> getGoodsName(int orderId);

    COrder getOrder(int orderId);

    COrder getOrderDetail(int orderId);

    List<COrder> getOrders(COrder cOrder);

    int updateOrder(COrder cOrder);

    int makeEvaluate(CEvaluate cEvaluate);

    List<CEvaluate> showEvaluate(int userId);

    List<CEvaluate> showAllEvaluate();

    int addEvaluateReply(CEvaluateReply cEvaluateReply);
}
