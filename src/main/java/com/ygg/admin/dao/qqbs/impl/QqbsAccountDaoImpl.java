/**************************************************************************
 * Copyright (c) 2014-2016 浙江格家网络技术有限公司.
 * All rights reserved.
 * 
 * 项目名称：左岸城堡
APP
 * 版权说明：本软件属浙江格家网络技术有限公司所有，在未获得浙江格家网络技术有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ygg.admin.dao.qqbs.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ygg.admin.dao.impl.mybatis.base.BaseDaoImpl;
import com.ygg.admin.dao.qqbs.QqbsAccountDao;
import com.ygg.admin.entity.qqbs.QqbsAccountEntity;
import com.ygg.admin.exception.DaoException;

/**
 * TODO 请在此处添加注释
 * 
 * @author <a href="mailto:zhangld@yangege.com">zhangld</a>
 * @version $Id: QqbsAccountDaoImpl.java 12585 2016-05-23 07:15:51Z wuhuyun $
 * @since 2.0
 */
@Repository("qqbsAccountDao")
public class QqbsAccountDaoImpl extends BaseDaoImpl implements QqbsAccountDao
{
    
    /**
     * @param account
     * @return
     * @throws DaoException
     */
    public int updateAccounSpread(Map<String, Object> para)
    {
        return this.getSqlSession().update("QqbsAccountMapper.updateAccounSpread", para);
    }
    
    /**
     * TODO 请在此处添加注释
     * 
     * @param openId
     * @return
     * @throws DaoException
     */
    public QqbsAccountEntity findAccountByAccountId(int accountId)
    {
        QqbsAccountEntity ae = getSqlSession().selectOne("QqbsAccountMapper.findAccountByAccountId", accountId);
        return ae;
    }
    
    @Override
    public List<QqbsAccountEntity> findAccountsByQqbsUserQueryCriteria(QqbsAccountEntity qqbsUserQueryCriteria)
    {
        return getSqlSessionRead().selectList("QqbsAccountMapper.findAccountsByQqbsUserQueryCriteria", qqbsUserQueryCriteria);
    }
    
    @Override
    public int countQqbsAccountByQqbsUserQueryCriteria(QqbsAccountEntity qqbsUserQueryCriteria)
    {
        return getSqlSessionRead().selectOne("QqbsAccountMapper.countQqbsAccountByQqbsUserQueryCriteria", qqbsUserQueryCriteria);
    }
    
    @Override
    public int addPersistentQRCodeToAccount(QqbsAccountEntity qqbsAccountEntity)
    {
        return getSqlSession().update("QqbsAccountMapper.addPersistentQRCodeToAccount", qqbsAccountEntity);
        
    }
}
