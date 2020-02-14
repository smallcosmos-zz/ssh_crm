package cn.itheima.dao.impl;

import cn.itheima.dao.BaseDictDao;
import cn.itheima.domain.BaseDict;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {
    @Override
    public List<BaseDict> getListByDicyTypeCode(String dict_type_code) {
        DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
        dc.add(Restrictions.eq("dict_type_code",dict_type_code));
        List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
        return list;
    }

}
