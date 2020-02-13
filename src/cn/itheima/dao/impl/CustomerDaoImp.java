package cn.itheima.dao.impl;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImp extends BaseDaoImpl<Customer> implements CustomerDao {}
