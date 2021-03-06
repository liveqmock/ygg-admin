package com.ygg.admin.controller.yw.brand;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ygg.admin.annotation.ControllerLog;
import com.ygg.admin.entity.yw.YwBrandCategoryEntity;
import com.ygg.admin.service.yw.brand.YwBrandCategoryService;
import com.ygg.admin.util.CommonUtil;


@Controller
@RequestMapping("ywBrandCategory")
public class YwBrandCategoryController
{
    private static Logger logger = Logger.getLogger(YwBrandCategoryController.class);

    @Resource
    private YwBrandCategoryService ywBrandCategoryService;
    
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request)
        throws Exception
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ywBrand/ywBrandCategory");
        return mv;
    }
    
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ControllerLog(description = "品牌馆管理-新增更新商品")
    public String saveOrUpdate(HttpServletRequest request)
    {
        Map<String, Object> statusMap = new HashMap<String, Object>();
        int status = 0;
        String msg = null;
        try
        {
            YwBrandCategoryEntity category = new YwBrandCategoryEntity();
            CommonUtil.wrapParamter2Entity(category, request);
            if(0==category.getId()){
                status = ywBrandCategoryService.addBrandCategory(category);
            }else{
                status = ywBrandCategoryService.updateBrandCategory(category);
            }
            msg = "保存成功";
        }
        catch (Exception e)
        {
            statusMap.put("status", 0);
            statusMap.put("msg", "保存失败");
            logger.error("编辑商品出错", e);
        }finally{
            statusMap.put("status", status);
            statusMap.put("msg", msg);
        }
        return JSON.toJSONString(statusMap);
    }
    
    
    @RequestMapping(value = "/updateCategoryDisplay", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @ControllerLog(description = "品牌馆管理-展现不展现")
    public String updateCategoryDisplay(HttpServletRequest request)
    {
        Map<String, Object> statusMap = new HashMap<String, Object>();
        int status = 0;
        String msg = null;
        try
        {
            YwBrandCategoryEntity category = new YwBrandCategoryEntity();
            CommonUtil.wrapParamter2Entity(category, request);
            status = ywBrandCategoryService.updateBrandCategory(category);
            msg = "保存成功";
        }
        catch (Exception e)
        {
            statusMap.put("status", 0);
            statusMap.put("msg", "保存失败");
            logger.error("编辑品牌展现出错", e);
        }finally{
            statusMap.put("status", status);
            statusMap.put("msg", msg);
        }
        return JSON.toJSONString(statusMap);
    }
    
    @RequestMapping(value = "/jsonBrandCategoryInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String jsonBrandCategoryInfo(  
            @RequestParam(value = "page", required = true, defaultValue = "1") int page,
            @RequestParam(value = "rows", required = true, defaultValue = "50") int rows)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try
        {
            Map<String, Object> para = new HashMap<String, Object>();
            if (page == 0) page = 1;
            para.put("start", rows * (page - 1));
            para.put("max", rows);
            resultMap = ywBrandCategoryService.findBrandCategoryInfo(para);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            resultMap.put("status",0);
            resultMap.put("msg","加载列表失败");
        }
        return JSON.toJSONString(resultMap);
    }
    
}
