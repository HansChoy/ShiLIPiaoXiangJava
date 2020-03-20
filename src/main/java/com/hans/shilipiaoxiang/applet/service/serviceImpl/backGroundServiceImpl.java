package com.hans.shilipiaoxiang.applet.service.serviceImpl;
import java.util.List;
import com.hans.shilipiaoxiang.applet.mapper.CAdminMapper;
import com.hans.shilipiaoxiang.applet.mapper.CGoodsMapper;
import com.hans.shilipiaoxiang.applet.pojo.CAdmin;
import com.hans.shilipiaoxiang.applet.pojo.CGoods;
import com.hans.shilipiaoxiang.applet.service.backGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class backGroundServiceImpl implements backGroundService {
    @Autowired
    private CAdminMapper cAdminMapper;
    @Autowired
    private CGoodsMapper cGoodsMapper;
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
}
