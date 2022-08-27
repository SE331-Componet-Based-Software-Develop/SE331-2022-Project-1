package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZuixingonggaoEntity;
import com.entity.view.ZuixingonggaoView;

import com.service.ZuixingonggaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 最新公告
 * 后端接口
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
@RestController
@RequestMapping("/zuixingonggao")
public class ZuixingonggaoController {
    @Autowired
    private ZuixingonggaoService zuixingonggaoService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuixingonggaoEntity zuixingonggao, HttpServletRequest request){

        EntityWrapper<ZuixingonggaoEntity> ew = new EntityWrapper<ZuixingonggaoEntity>();
		PageUtils page = zuixingonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuixingonggao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuixingonggaoEntity zuixingonggao, HttpServletRequest request){
        EntityWrapper<ZuixingonggaoEntity> ew = new EntityWrapper<ZuixingonggaoEntity>();
		PageUtils page = zuixingonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuixingonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuixingonggaoEntity zuixingonggao){
       	EntityWrapper<ZuixingonggaoEntity> ew = new EntityWrapper<ZuixingonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuixingonggao, "zuixingonggao")); 
        return R.ok().put("data", zuixingonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuixingonggaoEntity zuixingonggao){
        EntityWrapper< ZuixingonggaoEntity> ew = new EntityWrapper< ZuixingonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuixingonggao, "zuixingonggao")); 
		ZuixingonggaoView zuixingonggaoView =  zuixingonggaoService.selectView(ew);
		return R.ok("查询最新公告成功").put("data", zuixingonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ZuixingonggaoEntity zuixingonggao = zuixingonggaoService.selectById(id);
        return R.ok().put("data", zuixingonggao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ZuixingonggaoEntity zuixingonggao = zuixingonggaoService.selectById(id);
        return R.ok().put("data", zuixingonggao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuixingonggaoEntity zuixingonggao, HttpServletRequest request){
    	zuixingonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuixingonggao);

        zuixingonggaoService.insert(zuixingonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuixingonggaoEntity zuixingonggao, HttpServletRequest request){
    	zuixingonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuixingonggao);

        zuixingonggaoService.insert(zuixingonggao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZuixingonggaoEntity zuixingonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuixingonggao);
        zuixingonggaoService.updateById(zuixingonggao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuixingonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZuixingonggaoEntity> wrapper = new EntityWrapper<ZuixingonggaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = zuixingonggaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	

}
