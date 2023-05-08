package Problem1.solution.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {

	private String name;
	private List<CategoryDto> children;

	public CategoryDto(String name) {
		this.name = name;
		this.children = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryDto> getChildren() {
		return children;
	}

	public void addChildren(CategoryDto child) {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}

		this.children.add(child);
	}


	@Override
	public String toString() {
		return "CategoryDto{" +
			"name='" + name + "'" +
			"children=" + children +
			"}";
	}
}
