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

import com.entity.YimiaomingchengEntity;
import com.entity.view.YimiaomingchengView;

import com.service.YimiaomingchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 疫苗名称
 * 后端接口
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
@RestController
@RequestMapping("/yimiaomingcheng")
public class YimiaomingchengController {
    @Autowired
    private YimiaomingchengService yimiaomingchengService;
    

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YimiaomingchengEntity yimiaomingcheng, HttpServletRequest request){

        EntityWrapper<YimiaomingchengEntity> ew = new EntityWrapper<YimiaomingchengEntity>();
		PageUtils page = yimiaomingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yimiaomingcheng), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YimiaomingchengEntity yimiaomingcheng, HttpServletRequest request){
        EntityWrapper<YimiaomingchengEntity> ew = new EntityWrapper<YimiaomingchengEntity>();
		PageUtils page = yimiaomingchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yimiaomingcheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YimiaomingchengEntity yimiaomingcheng){
       	EntityWrapper<YimiaomingchengEntity> ew = new EntityWrapper<YimiaomingchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yimiaomingcheng, "yimiaomingcheng")); 
        return R.ok().put("data", yimiaomingchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YimiaomingchengEntity yimiaomingcheng){
        EntityWrapper< YimiaomingchengEntity> ew = new EntityWrapper< YimiaomingchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yimiaomingcheng, "yimiaomingcheng")); 
		YimiaomingchengView yimiaomingchengView =  yimiaomingchengService.selectView(ew);
		return R.ok("查询疫苗名称成功").put("data", yimiaomingchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        YimiaomingchengEntity yimiaomingcheng = yimiaomingchengService.selectById(id);
        return R.ok().put("data", yimiaomingcheng);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        YimiaomingchengEntity yimiaomingcheng = yimiaomingchengService.selectById(id);
        return R.ok().put("data", yimiaomingcheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YimiaomingchengEntity yimiaomingcheng, HttpServletRequest request){
    	yimiaomingcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yimiaomingcheng);

        yimiaomingchengService.insert(yimiaomingcheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YimiaomingchengEntity yimiaomingcheng, HttpServletRequest request){
    	yimiaomingcheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yimiaomingcheng);

        yimiaomingchengService.insert(yimiaomingcheng);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YimiaomingchengEntity yimiaomingcheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yimiaomingcheng);
        yimiaomingchengService.updateById(yimiaomingcheng);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yimiaomingchengService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<YimiaomingchengEntity> wrapper = new EntityWrapper<YimiaomingchengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yimiaomingchengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	

}
