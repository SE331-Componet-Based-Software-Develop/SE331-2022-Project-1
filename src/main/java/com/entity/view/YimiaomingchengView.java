package com.entity.view;

import com.entity.YimiaomingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 疫苗名称
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
@TableName("yimiaomingcheng")
public class YimiaomingchengView  extends YimiaomingchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YimiaomingchengView(){
	}
 
 	public YimiaomingchengView(YimiaomingchengEntity yimiaomingchengEntity){
 	try {
			BeanUtils.copyProperties(this, yimiaomingchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
