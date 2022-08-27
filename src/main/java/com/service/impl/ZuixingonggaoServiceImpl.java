package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZuixingonggaoDao;
import com.entity.ZuixingonggaoEntity;
import com.service.ZuixingonggaoService;
import com.entity.vo.ZuixingonggaoVO;
import com.entity.view.ZuixingonggaoView;

@Service("zuixingonggaoService")
public class ZuixingonggaoServiceImpl extends ServiceImpl<ZuixingonggaoDao, ZuixingonggaoEntity> implements ZuixingonggaoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuixingonggaoEntity> page = this.selectPage(
                new Query<ZuixingonggaoEntity>(params).getPage(),
                new EntityWrapper<ZuixingonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuixingonggaoEntity> wrapper) {
		  Page<ZuixingonggaoView> page =new Query<ZuixingonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZuixingonggaoVO> selectListVO(Wrapper<ZuixingonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZuixingonggaoVO selectVO(Wrapper<ZuixingonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZuixingonggaoView> selectListView(Wrapper<ZuixingonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuixingonggaoView selectView(Wrapper<ZuixingonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
