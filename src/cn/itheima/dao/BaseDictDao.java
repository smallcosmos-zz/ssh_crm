package cn.itheima.dao;

import cn.itheima.domain.BaseDict;

import java.util.List;

public interface BaseDictDao extends BaseDao<BaseDict>{
    List<BaseDict> getListByDicyTypeCode(String dict_type_code);
}
