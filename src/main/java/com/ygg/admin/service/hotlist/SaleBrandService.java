
 /**************************************************************************
 * Copyright (c) 2014-2016 浙江格家网络技术有限公司.
 * All rights reserved.
 * 
 * 项目名称：左岸城堡APP
 * 版权说明：本软件属浙江格家网络技术有限公司所有，在未获得浙江格家网络技术有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ygg.admin.service.hotlist;

import java.util.Map;

import com.ygg.admin.entity.hotlist.SelaBrandEntity;

/**
  * TODO 请在此处添加注释
  * @author <a href="mailto:zhangld@yangege.com">zhangld</a>
  * @version $Id: SaleBrandService.java 9166 2016-03-23 06:25:13Z zhanglide $   
  * @since 2.0
  */
public interface SaleBrandService {
	/**
	 * 查询推荐列表
	 * @param param
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	Map<String, Object> findListInfo(Map<String, Object> param) throws Exception;
	
	/**
	 * 新增或更新推荐
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int saveOrUpdateInfo(Map<String, Object> param) throws Exception;
	
	/**
	 * 查询单条
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> findByIdOrProductBaseId(int id,int productBaseId) throws Exception;
	
	/**
	 * TODO 请在此处添加注释
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(int id) throws Exception;
	
	
	
	/**
	 * 根据基本商品id获取符合要求的热卖单品
	 * @param productBaseId
	 * @return
	 * @throws Exception
	 */
	public SelaBrandEntity getBrandInfo(Map<String, Object> para)throws Exception;
	
	
	public int getCount(Map<String, Object> para)throws Exception;
}
