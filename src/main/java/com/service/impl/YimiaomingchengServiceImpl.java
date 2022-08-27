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


import com.dao.YimiaomingchengDao;
import com.entity.YimiaomingchengEntity;
import com.service.YimiaomingchengService;
import com.entity.vo.YimiaomingchengVO;
import com.entity.view.YimiaomingchengView;

@Service("yimiaomingchengService")
public class YimiaomingchengServiceImpl extends ServiceImpl<YimiaomingchengDao, YimiaomingchengEntity> implements YimiaomingchengService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YimiaomingchengEntity> page = this.selectPage(
                new Query<YimiaomingchengEntity>(params).getPage(),
                new EntityWrapper<YimiaomingchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YimiaomingchengEntity> wrapper) {
		  Page<YimiaomingchengView> page =new Query<YimiaomingchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YimiaomingchengVO> selectListVO(Wrapper<YimiaomingchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YimiaomingchengVO selectVO(Wrapper<YimiaomingchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YimiaomingchengView> selectListView(Wrapper<YimiaomingchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YimiaomingchengView selectView(Wrapper<YimiaomingchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
