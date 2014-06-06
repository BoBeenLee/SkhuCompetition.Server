package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Valuer;
import competition.domain.view.ValuerView;
import competition.mapper.ValuerMapper;
import competition.service.ValuerService;

@Service("valuerService")
public class ValuerServiceImpl implements ValuerService{
	@Autowired
	ValuerMapper valuerMapper;
	
	public boolean addValuer(Valuer valuer) {
		boolean isValuer = (1 == valuerMapper.addValuer(valuer))? true : false;
		return isValuer;
	}

	public boolean removeValuer(int valuerId) {
		boolean isValuer = (1 == valuerMapper.removeValuer(valuerId))? true : false;
		return isValuer;
	}

	public boolean modifyValuer(Valuer valuer) {
		boolean isValuer = (1 == valuerMapper.modifyValuer(valuer))? true : false;
		return isValuer;
	}

	public ValuerView getValuer(String userId, int boardCodeId) {
		ValuerView valuerView = valuerMapper.getValuer(userId, boardCodeId);
		return valuerView;
	}

	public List<ValuerView> findValuers(int boardCodeId) {
		List<ValuerView> valuerList = valuerMapper.findValuers(boardCodeId);
		return valuerList;
	}
}
