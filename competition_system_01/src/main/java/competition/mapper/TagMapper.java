package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Tag;
import competition.domain.view.TagView;

public interface TagMapper {
	public int addTag(Tag tag);
	public int modifyTag(Tag tag);
	public int removeTag(int tagId);
	public TagView getTag(int tagId);
	public List<TagView> findTags(@Param("fileId") int fileId, @Param("tagName") String tagName);
	public List<TagView> findTagTypes();
}