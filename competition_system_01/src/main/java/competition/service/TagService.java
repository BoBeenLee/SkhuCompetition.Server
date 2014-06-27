package competition.service;

import java.util.List;

import competition.domain.Tag;
import competition.domain.view.TagView;

public interface TagService {
	public boolean addTag(Tag tag);
	public boolean modifyTag(Tag tag);
	public boolean removeTag(int tagId);
	public TagView getTag(int tagId);
	public List<TagView> findTags(int fieldId);
	public List<TagView> findTags(String tagName);
	public List<TagView> findTags(int fileId, String tagName);
	public List<TagView> findTagTypes();	
}
