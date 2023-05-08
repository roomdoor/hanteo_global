package Problem1.solution.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

	Optional<T> findById(long index);

	T save(T entity);

	void deleteById(long index);

	List<T> findAll();
}
