package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import competition.domain.Valuer;
import competition.domain.view.ValuerView;

public interface ValuerMapper {
	public int addValuer(Valuer valuer);
	public int removeValuer(int valuerId);
	public int modifyValuer(Valuer valuer);
	public ValuerView getValuer(@Param("userId") String userId, @Param("boardCodeId") int boardCodeId);
	public List<ValuerView> findValuers(int boardCodeId);
}
