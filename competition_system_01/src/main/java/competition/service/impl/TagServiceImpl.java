package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Tag;
import competition.domain.view.TagView;
import competition.mapper.TagMapper;
import competition.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService{
	@Autowired(required=false)
	TagMapper tagMapper;
	
	public boolean addTag(Tag tag) {
		boolean isTag = (1 == tagMapper.addTag(tag))? true : false;
		return isTag;
	}

	public boolean modifyTag(Tag tag) {
		boolean isTag = (1 == tagMapper.modifyTag(tag))? true : false;
		return isTag;
	}
	
	public boolean removeTag(int tagId) {
		boolean isTag = (1 == tagMapper.removeTag(tagId))? true : false;
		return isTag;
	}

	public TagView getTag(int tagId) {
		TagView tagView = tagMapper.getTag(tagId);
		return tagView;
	}

	public List<TagView> findTags(int fileId, String tagName) {
		List<TagView> tagList = tagMapper.findTags(fileId, tagName);
		return tagList;
	}

	public List<TagView> findTags(int fieldId) {
		List<TagView> tagList = this.findTags(fieldId, null);
		return tagList;
	}

	public List<TagView> findTags(String tagName) {
		List<TagView> tagList = this.findTags(0, tagName);
		return tagList;
	}

	public List<TagView> findTagTypes() {
		List<TagView> tagList = tagMapper.findTagTypes();
		return tagList;
	}
}
