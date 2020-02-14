package cn.itheima.service;

import cn.itheima.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> getListByDicyTypeCode(String dict_type_code);
}
