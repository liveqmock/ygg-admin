
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
package com.ygg.admin.dao.hotlist;

import java.util.List;
import java.util.Map;

import com.ygg.admin.entity.hotlist.SelaBrandEntity;

/**
  * TODO 请在此处添加注释
  * @author <a href="mailto:zhangld@yangege.com">zhangld</a>
  * @version $Id: SaleBrandDao.java 9166 2016-03-23 06:25:13Z zhanglide $   
  * @since 2.0
  */
public interface SaleBrandDao {
	/**
     * 查询推荐列表
     * @param param
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> findListInfo(Map<String, Object> param)
        throws Exception;
    
    /**
     * 统计条数
     * @param param
     * @return
     * @throws Exception
     */
    int getCountByParam(Map<String, Object> param)
        throws Exception;
    
    public int save(Map<String, Object> param)
        throws Exception;
    
    public int update(Map<String, Object> param)
        throws Exception;
    public int delete(int id) throws Exception;
    /**
     * 获取热卖商品信息
     * @param para
     * @return List<SaleSingleProduct>
     * @throws Exception 异常时
     */
    public SelaBrandEntity getBrandInfo(Map<String, Object> para)throws Exception;
}
