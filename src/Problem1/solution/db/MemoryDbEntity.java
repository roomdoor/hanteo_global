package Problem1.solution.db;

public class MemoryDbEntity {

	protected Long index;


	public MemoryDbEntity() {
	}

	public MemoryDbEntity(Long index) {
		this.index = index;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}
}
