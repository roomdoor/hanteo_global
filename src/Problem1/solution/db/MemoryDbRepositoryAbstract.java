package Problem1.solution.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements
	MemoryDbRepositoryIfs<T> {

	private final List<T> db = new ArrayList<>();
	private long index = 0;

	@Override
	public Optional<T> findById(long index) {
		return db.stream().filter(it -> it.getIndex() == index).findFirst();
	}

	@Override
	public T save(T entity) {
		var optionalEntity = db.stream().filter(it -> it.getIndex().equals(entity.getIndex()))
			.findFirst();
		if (optionalEntity.isEmpty()) {
			index++;
			entity.setIndex(index);

		} else {
			var preIndex = optionalEntity.get().getIndex();
			entity.setIndex(preIndex);
			deleteById(preIndex);

		}

		db.add(entity);
		return entity;
	}

	@Override
	public void deleteById(long index) {
		var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();

		optionalEntity.ifPresent(db::remove);

	}

	@Override
	public List<T> findAll() {
		return db;
	}
}
