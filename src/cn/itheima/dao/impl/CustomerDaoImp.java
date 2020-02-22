package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

public class CustomerDaoImp extends BaseDaoImpl<Customer> implements CustomerDao {
    @Override
    public List<Object[]> getIndustryTotal(String type) {
       List<Object[]> list =  getHibernateTemplate().execute(new HibernateCallback<List>() {
           String sql =  "  SELECT                  "+
                   "  bd.dict_item_name,            "+
                   "          count( * ) total,      "+
                   "          bd.dict_type_code      "+
                   "          FROM                  "+
                   "  cst_customer c,               "+
                   "  base_dict bd                  "+
                   "  WHERE                         "+
                   "  c."+type+" = bd.dict_id  "+
                   "  GROUP BY                      "+
                   "  c."+type+"             ";
            @Override
            public List doInHibernate(Session session) throws HibernateException {

                SQLQuery sqlQuery = session.createSQLQuery(sql);

                return sqlQuery.list();
            }
        });
        return list;
    }
}
