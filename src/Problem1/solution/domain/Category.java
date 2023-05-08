package Problem1.solution.domain;

import Problem1.solution.db.MemoryDbEntity;
import java.util.ArrayList;
import java.util.List;

public class Category extends MemoryDbEntity {

	private Long parent_idx;
	private List<Long> child_idxes;
	private String name;

	public Category(String name) {
		this.name = name;
		this.child_idxes = new ArrayList<>();
	}

	public Long getParent_idx() {
		return parent_idx;
	}

	public void setParent_idx(Long parent_idx) {
		this.parent_idx = parent_idx;
	}

	public List<Long> getChild_idxes() {
		return child_idxes;
	}

	public void addChild_idx(Long child_idx) {
		if (this.child_idxes == null) {
			this.child_idxes = new ArrayList<>();
		}

		this.child_idxes.add(child_idx);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category{" +
			"index=" + index +
			", name='" + name + '\'' +
			'}';
	}
}
