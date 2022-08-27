package com.entity.vo;

import com.entity.YimiaomingchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 疫苗名称
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2020-05-19 11:18:58
 */
public class YimiaomingchengVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 疫苗名称
	 */
	
	private String yimiaomingcheng;
		
	/**
	 * 疫苗类型
	 */
	
	private String yimiaoleixing;
		
	/**
	 * 库存数量
	 */
	
	private Integer kucunshuliang;
		
	/**
	 * 接种年龄
	 */
	
	private String jiezhongnianling;
		
	/**
	 * 详情
	 */
	
	private String xiangqing;
				
	
	/**
	 * 设置：疫苗名称
	 */
	 
	public void setYimiaomingcheng(String yimiaomingcheng) {
		this.yimiaomingcheng = yimiaomingcheng;
	}
	
	/**
	 * 获取：疫苗名称
	 */
	public String getYimiaomingcheng() {
		return yimiaomingcheng;
	}
				
	
	/**
	 * 设置：疫苗类型
	 */
	 
	public void setYimiaoleixing(String yimiaoleixing) {
		this.yimiaoleixing = yimiaoleixing;
	}
	
	/**
	 * 获取：疫苗类型
	 */
	public String getYimiaoleixing() {
		return yimiaoleixing;
	}
				
	
	/**
	 * 设置：库存数量
	 */
	 
	public void setKucunshuliang(Integer kucunshuliang) {
		this.kucunshuliang = kucunshuliang;
	}
	
	/**
	 * 获取：库存数量
	 */
	public Integer getKucunshuliang() {
		return kucunshuliang;
	}
				
	
	/**
	 * 设置：接种年龄
	 */
	 
	public void setJiezhongnianling(String jiezhongnianling) {
		this.jiezhongnianling = jiezhongnianling;
	}
	
	/**
	 * 获取：接种年龄
	 */
	public String getJiezhongnianling() {
		return jiezhongnianling;
	}
				
	
	/**
	 * 设置：详情
	 */
	 
	public void setXiangqing(String xiangqing) {
		this.xiangqing = xiangqing;
	}
	
	/**
	 * 获取：详情
	 */
	public String getXiangqing() {
		return xiangqing;
	}
			
}
