package com.hans.shilipiaoxiang.applet.service.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import com.hans.shilipiaoxiang.applet.Select.AmountResult;
import com.hans.shilipiaoxiang.applet.mapper.CAdminMapper;
import com.hans.shilipiaoxiang.applet.mapper.CGoodsMapper;
import com.hans.shilipiaoxiang.applet.mapper.COrderMapper;
import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.pojo.COrder;
import com.hans.shilipiaoxiang.applet.Select.SelectParams;
import com.hans.shilipiaoxiang.applet.service.backGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class backGroundServiceImpl implements backGroundService {
    @Autowired
    private CAdminMapper cAdminMapper;
    @Autowired
    private CGoodsMapper cGoodsMapper;
    @Autowired
    private COrderMapper cOrderMapper;
    @Override
    public CAdmin login(String username) {
        CAdmin cAdmin=cAdminMapper.login(username);
        return cAdmin;
    }

    @Override
    public List<CGoods> showGoods() {
        List<CGoods> cGoodsList=cGoodsMapper.showGoods();
        return cGoodsList;
    }

    @Override
    public List<AmountResult> showAmout(SelectParams selectParams) {
        List<AmountResult> amountResultList=new ArrayList<>();
        if(selectParams.getTypeId()==0){
            amountResultList=cOrderMapper.showAmount(selectParams);
        }else {
            amountResultList=cOrderMapper.showAmountDetail(selectParams);
        }
        return amountResultList;
    }

    @Override
    public List<CGoods> showGoodsName(int typeId) {
        List<CGoods> cGoodsList=cGoodsMapper.showGoodsName(typeId);
        return cGoodsList;
    }
}
