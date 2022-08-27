package com.entity.view;

import com.entity.ZuixingonggaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 最新公告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
@TableName("zuixingonggao")
public class ZuixingonggaoView  extends ZuixingonggaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZuixingonggaoView(){
	}
 
 	public ZuixingonggaoView(ZuixingonggaoEntity zuixingonggaoEntity){
 	try {
			BeanUtils.copyProperties(this, zuixingonggaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
