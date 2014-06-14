package competition.service;

import java.util.List;

import competition.domain.Valuer;
import competition.domain.view.ValuerView;

public interface ValuerService {
	public boolean addValuer(Valuer valuer);
	public boolean removeValuers(int boardCodeId);
	public boolean modifyValuer(Valuer valuer);
	public ValuerView getValuer(String userId, int boardCodeId);
	public List<ValuerView> findValuers(int boardCodeId, String userId);
}
