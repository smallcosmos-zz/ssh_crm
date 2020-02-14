package cn.itheima.service.Impl;

import cn.itheima.dao.BaseDictDao;
import cn.itheima.domain.BaseDict;
import cn.itheima.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
    private BaseDictDao bsd;

    public void setBsd(BaseDictDao bsd) {
        this.bsd = bsd;
    }

    @Override
    public List<BaseDict> getListByDicyTypeCode(String dict_type_code) {
        return bsd.getListByDicyTypeCode(dict_type_code);
    }

}
